package soc.assure.services;
import soc.assure.models.Assure;

import java.util.List;

public interface AssureService {

    Assure addAssure (Assure assure);
    List<Assure> RetreiveAllAssure ();
    Assure updateAssure(Assure assure);
    Assure findById (String id);

}
