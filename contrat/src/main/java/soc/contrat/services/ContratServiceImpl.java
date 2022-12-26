package soc.contrat.services;

import soc.contrat.services.Dto.*;
import soc.contrat.models.Contrat;
import soc.contrat.repositories.ContratRepository;
import soc.contrat.services.Dto.ContratDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService{
    @Autowired
    ContratRepository contratRepository;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;
    private APIClient apiClient;

    //private static final String GET_USER_BY_ID_API = "http://localhost:8085/api/test/getUser/{id}";

    /*public User getUserByRestTemplate(String id){
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        User user = restTemplateBuilder.build().getForObject(GET_USER_BY_ID_API, User.class, param);
        return user;
    }*/

    @Override
    public Contrat addContrat(ContratDto contratDto) {
        Contrat contrat = new Contrat(
                contratDto.getNum(),
                contratDto.getDateDeb(),
                contratDto.getDateFin(),
                contratDto.getAssureId()
               
        );
        return contratRepository.save(contrat);
    }
    @Override
    public List<Contrat> RetreiveAllContrat() {
        return contratRepository.findAll();
    }

    public Contrat findByNum(String num) {

        return contratRepository.findById(num).get();
    }
    @Override
    public ResponseDto getContrat(String num) {

        ResponseDto responseDto = new ResponseDto();
        Contrat contrat = new Contrat() ;
        contrat = contratRepository.findById(num).get();
        ContratDto contratDto = mapToContrat(contrat);

        AssureDto assureDto = apiClient.getAssureById(contrat.getAssureId());
        responseDto.setContrat(contratDto);
        responseDto.setAssure(assureDto);

        // ResponseEntity<AssureDto> responseEntity = restTemplate
        // .getForEntity("http://localhost:8082/assure/retrieve-all-Assure", AssureDto.class);

        // AssureDto assureDto = responseEntity.getBody();

        // System.out.println(responseEntity.getStatusCode());

        // responseDto.setContrat(contratDto);
        // responseDto.setAssure(assureDto);

        return responseDto;
    }

    private ContratDto mapToContrat(Contrat contrat){
        ContratDto contratDto = new ContratDto();
        contratDto.setNum(contrat.getNum());
        contratDto.setDateDeb(contrat.getDateDeb());
        contratDto.setDateFin(contrat.getDateFin());
        contratDto.setAssureId(contrat.getAssureId());
        return contratDto;
    }

}
