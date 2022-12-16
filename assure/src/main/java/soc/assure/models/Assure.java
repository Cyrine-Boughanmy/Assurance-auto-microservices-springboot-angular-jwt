package soc.assure.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import javax.validation.constraints.Email;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "assures")
public class Assure {

    @Id
    private String id_assure;

    private String insured_firstname;

    private String insured_lastname;

    // @Email
    private String email;

    private String phone;

    private String adresse;

    private int cin;

}