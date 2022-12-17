package soc.assurance.services;

import soc.assurance.models.Assurance;
import soc.assurance.services.Dto.AssuranceDto;
import java.util.List;



public interface AssuranceService {

    public Assurance addAssurance(AssuranceDto assuranceDTO);
    public List<Assurance> RetreiveAllAssurance();
    public List<Assurance> findAssurByInsuranceId(String insuranceId) ;

    }