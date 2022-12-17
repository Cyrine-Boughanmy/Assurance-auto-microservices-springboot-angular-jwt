package soc.vehicule.services.Dto;

// import soc.vehicule.models.Assurance;
// import soc.vehicule.models.Contrat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculeDto {

    private String idv;
    private boolean company;
    private boolean assigned;
    private boolean owner;
    private boolean validCertificate;
    private String carBrand;
    private String immatricule;

    // private Contrat contrat;
    // private Assurance assurance;
}
