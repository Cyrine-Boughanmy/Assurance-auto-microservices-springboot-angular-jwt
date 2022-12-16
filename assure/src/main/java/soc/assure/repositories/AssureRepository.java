package soc.assure.repositories;
import soc.assure.models.Assure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssureRepository extends MongoRepository<Assure, String> {

}