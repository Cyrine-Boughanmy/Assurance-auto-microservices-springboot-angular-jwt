package soc.assurance.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "assurances")
public class Assurance {

    @Id
    private String insuranceId;

    private String insuranceLabel;

    private String insurance_num;

    private String agence;
}
