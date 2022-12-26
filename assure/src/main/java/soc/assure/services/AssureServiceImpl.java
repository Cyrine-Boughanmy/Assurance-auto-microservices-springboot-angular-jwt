package soc.assure.services;

import soc.assure.models.*;
import soc.assure.repositories.AssureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AssureServiceImpl implements AssureService{

    @Autowired
    AssureRepository assureRepository;

    @Override
    public Assure addAssure(Assure assure) {
        return assureRepository.save(assure);
    }

    @Override
    public List<Assure> RetreiveAllAssure() {
        return assureRepository.findAll();
    }

    @Override
    public Assure updateAssure(Assure assure) {

        String id_assure = assure.getId_assure();
        Assure ass = assureRepository.findById(id_assure).get();

        ass.setInsured_firstname(assure.getInsured_firstname());
        ass.setInsured_lastname(assure.getInsured_lastname());
        ass.setEmail(assure.getEmail());
        ass.setPhone(assure.getPhone());
        ass.setAdresse(assure.getAdresse());
        ass.setCin(assure.getCin());

        return assureRepository.save(ass);
    }

    @Override
    public Assure findById(String id_assure) {
        return assureRepository.findById(id_assure).get();
    }



}