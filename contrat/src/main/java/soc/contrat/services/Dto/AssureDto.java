package soc.contrat.services.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssureDto {
    private String id_assure;

    private String insured_firstname;

    private String insured_lastname;

    // @Email
    private String email;

    private String phone;

    private String adresse;

    private int cin;
}
