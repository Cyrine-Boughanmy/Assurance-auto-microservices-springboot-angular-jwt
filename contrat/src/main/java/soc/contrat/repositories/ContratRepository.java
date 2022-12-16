package soc.contrat.repositories;

import soc.contrat.models.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ContratRepository extends MongoRepository<Contrat, String> {

}