package soc.vehicule.services;

import soc.vehicule.models.Vehicule;
import soc.vehicule.services.Dto.VehiculeDto;

import java.util.List;

public interface VehiculeService {

    public Vehicule addVehicule(VehiculeDto vehiculeDTO) ;
    List<Vehicule> RetreiveAllVehicule ();
    Vehicule updateVehicule(Vehicule vehicule, String idv);
    public void DeleteVehicule(String idv);

    public Vehicule findById(String idv);
    }
