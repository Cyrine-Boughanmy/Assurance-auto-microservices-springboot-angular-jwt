package soc.vehicule.services;

import soc.vehicule.models.Vehicule;
import soc.vehicule.repositories.VehiculeRepository;
import soc.vehicule.services.Dto.VehiculeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {

    @Autowired
    VehiculeRepository vehiculeRepository;


    @Override
    public Vehicule addVehicule(VehiculeDto vehiculeDTO) {
        Vehicule vehicule = new Vehicule(
                vehiculeDTO.getIdv(),
                vehiculeDTO.isCompany(),
                vehiculeDTO.isAssigned(),
                vehiculeDTO.isOwner(),
                vehiculeDTO.isValidCertificate(),
                vehiculeDTO.getCarBrand(),
                vehiculeDTO.getImmatricule(),
                vehiculeDTO.getContrat(),
                vehiculeDTO.getAssurance()
        );
        return vehiculeRepository.save(vehicule);
    }
    @Override
    public List<Vehicule> RetreiveAllVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule,String idv) {
        vehicule.setIdv(idv);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void DeleteVehicule(String idv) {
        vehiculeRepository.deleteById(idv);
    }

    @Override
    public Vehicule findById(String idv) {
        return vehiculeRepository.findById(idv).get();
    }
}
