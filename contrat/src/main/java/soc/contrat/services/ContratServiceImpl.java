package soc.contrat.services;

import soc.contrat.models.Contrat;
import soc.contrat.repositories.ContratRepository;
import soc.contrat.services.Dto.ContratDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContratServiceImpl implements ContratService{
    @Autowired
    ContratRepository contratRepository;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

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
                contratDto.getAssure()
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

}
