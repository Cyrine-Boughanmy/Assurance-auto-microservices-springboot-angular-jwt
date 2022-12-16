package soc.assure.controllers;

import soc.assure.models.Assure;
import soc.assure.services.AssureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/assure")
public class AssureController {

    @Autowired
    AssureServiceImpl assureService;

    @PostMapping("/Add")
    @ResponseBody
    public Assure addAssure(@RequestBody Assure assure){

       return assureService.addAssure(assure);
    }


    @GetMapping("/retrieve-all-Assure")
    @ResponseBody
    public List<Assure> getAllCreationidm() {
        List<Assure> list = assureService.RetreiveAllAssure();
        return list;
    }


    @GetMapping("/retrieve-Assure/{id_assure}")
    @ResponseBody
    public Assure getCreationidmById(@PathVariable("id_assure")String id_assure) {
        return assureService.findById(id_assure);
    }


    @PutMapping("/updateAssure")
    public Assure updateAssure(@RequestBody Assure assure) {
        return  assureService.updateAssure(assure);
    }
}