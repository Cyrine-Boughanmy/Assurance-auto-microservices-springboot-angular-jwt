package soc.contrat.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.Date;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contrats")
public class Contrat {

    @Id
    private String num;

    private Date dateDeb;

    private Date dateFin;
    
    private String assureId;

    // @DocumentReference
    // private Assure assure;
}
