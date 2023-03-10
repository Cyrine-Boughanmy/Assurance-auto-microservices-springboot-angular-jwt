package soc.contrat.controllers;

import soc.contrat.models.Contrat;
import soc.contrat.services.ContratServiceImpl;
import soc.contrat.services.Dto.ContratDto;
import soc.contrat.services.Dto.ResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    ContratServiceImpl contratService;


    @PostMapping(value = "/Add")
    public Contrat addContrat(@RequestBody ContratDto contratDTO){

        return contratService.addContrat(contratDTO) ;
    }

    @GetMapping("/all-contrat")
    @ResponseBody
    public List<Contrat> getAllCreationidm() {
        List<Contrat> list = contratService.RetreiveAllContrat();
        return list;
    }

    @GetMapping("/findByNum/{num}")
    @ResponseBody
    public Contrat findByNum(@PathVariable ("num") String num) {

        return contratService.findByNum(num);
    }
    @GetMapping("{num}")
    public ResponseEntity<ResponseDto> getContrat(@PathVariable("num") String num){
        ResponseDto responseDto = contratService.getContrat(num);
        return ResponseEntity.ok(responseDto);
    }

}