package soc.assurance.controllers;

import soc.assurance.models.Assurance;
import soc.assurance.services.AssuranceServiceImpl;
import soc.assurance.services.Dto.AssuranceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    @Autowired
    AssuranceServiceImpl assuranceService;

    @PostMapping(value = "/create")
    public Assurance addAssurance(@RequestBody AssuranceDto assuranceDTO){

        return assuranceService.addAssurance(assuranceDTO) ;
    }

    @GetMapping("/all-Assurance")
    @ResponseBody
    public List<Assurance> RetreiveAllAssurance() {
        List<Assurance> list = assuranceService.RetreiveAllAssurance();
        return list;
    }

    @GetMapping("/findAssurById/{insuranceId}")
    public List<Assurance> findAssurByInsuranceId(@PathVariable ("insuranceId") String insuranceId) {
        return assuranceService.findAssurByInsuranceId(insuranceId);
    }
}