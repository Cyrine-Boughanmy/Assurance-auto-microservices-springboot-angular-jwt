
package soc.assurance.services;

import soc.assurance.models.Assurance;
import soc.assurance.repositories.AssuranceRepository;
import soc.assurance.services.Dto.AssuranceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    AssuranceRepository assuranceRepository;

    @Override
    public Assurance addAssurance(AssuranceDto assuranceDTO) {

        Assurance assurance = new Assurance(
                assuranceDTO.getInsuranceId(),
                assuranceDTO.getInsuranceLabel(),
                assuranceDTO.getInsurance_num(),
                assuranceDTO.getAgence()
        );
        return assuranceRepository.save(assurance);
    }
    @Override
    public List<Assurance> RetreiveAllAssurance() {
        return assuranceRepository.findAll();
    }


    @Override
    public List<Assurance> findAssurByInsuranceId(String insuranceId) {

        List<Assurance> assurance = assuranceRepository.findAssurByInsuranceId(insuranceId);
        return assurance;
    }
}
