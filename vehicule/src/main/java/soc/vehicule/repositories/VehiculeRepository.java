package soc.vehicule.repositories;

import soc.vehicule.models.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculeRepository extends MongoRepository<Vehicule, String> {

}
