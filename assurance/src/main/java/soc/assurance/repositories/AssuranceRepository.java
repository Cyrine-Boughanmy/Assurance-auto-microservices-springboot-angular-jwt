package soc.assurance.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import soc.assurance.models.Assurance;

public interface AssuranceRepository extends MongoRepository<Assurance, String> {

    List<Assurance> findAssurByInsuranceId (String insuranceId);

}