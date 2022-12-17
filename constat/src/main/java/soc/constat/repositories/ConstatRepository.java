package soc.constat.repositories;

import soc.constat.models.Constat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConstatRepository extends MongoRepository<Constat, String> {
    @Override
    Optional<Constat> findById(String idc);

    @Query("{degats :'Degats Faibles'}")
    List<Constat> findConstatDF ();

    @Query("{degats :'Degats Eleves'}")
    List<Constat> findConstatDE ();

    // @Query("{etat :'Expert Affecte'}")
    // List<Constat> findConstatExpert ();

    @Query("{etat :'Dossier Cloture'}")
    List<Constat> findConstatCloture ();
}
