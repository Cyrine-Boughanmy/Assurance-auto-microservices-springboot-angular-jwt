package soc.vehicule.controllers;

import soc.vehicule.models.Vehicule;
import soc.vehicule.services.Dto.VehiculeDto;
import soc.vehicule.services.VehiculeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    @Autowired
    VehiculeServiceImpl vehiculeService;


    @PostMapping(value = "/create")
    public Vehicule addVehicule( @RequestBody VehiculeDto vehiculeDTO){

        return vehiculeService.addVehicule(vehiculeDTO) ;
    }

    @GetMapping("/all-Vehicule")
    @ResponseBody
    public List<Vehicule> getAllCreationidm() {
        List<Vehicule> list = vehiculeService.RetreiveAllVehicule();
        return list;
    }

    @DeleteMapping("/remove-Vehicule/{Vehicule-id}")
    @ResponseBody
    public void removeCreationidm(@PathVariable("Vehicule-id") String idv) {
        vehiculeService.DeleteVehicule(idv);
    }

    @PutMapping(value="/modify-Vehicule/{Vehicule-id}")
    public Vehicule modify(@PathVariable (name="Vehicule-id") String idv, @RequestBody Vehicule vehicule){
        return vehiculeService.updateVehicule(vehicule , idv);
    }

    @GetMapping("/findById/{idv}")
    @ResponseBody
    public Vehicule findById(@PathVariable("idv")String idv) {
        return vehiculeService.findById(idv);
    }
}