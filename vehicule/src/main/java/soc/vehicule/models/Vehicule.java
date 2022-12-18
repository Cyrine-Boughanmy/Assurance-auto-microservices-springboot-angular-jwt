package soc.vehicule.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vehicules")
public class Vehicule {

    @Id
    private String idv;
    private String company;
    private boolean assigned;
    private String owner;
    private boolean validCertificate;
    private String carBrand;
    private String immatricule;

    // @DocumentReference
    // private Contrat contrat;

    // @DocumentReference
    // private Assurance assurance;



}
