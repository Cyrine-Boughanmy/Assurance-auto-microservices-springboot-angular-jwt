package soc.contrat.services.Dto;

// import soc.assure.models.Assure;
import lombok.*;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratDto {

    private String num;

    private Date dateDeb;

    private Date dateFin;
    
    private String assureId;


}
