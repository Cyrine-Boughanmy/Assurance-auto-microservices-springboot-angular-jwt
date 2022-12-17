package soc.constat.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "constats1")
public class Constat {

    @Id
    private String idc;
    private Boolean typee;
    private Date date;
    // private Double lat;
    // private Double lng;
    private Boolean injury;
    private Boolean materieldamage;

//temoins
    private String witnessName;
    private String adress;
    private Number phone;
    private String type;



//conducteur
    private String firstnameC;
    private String lastnameC;
    private String adressC;
    private Number phoneC;
    private Number drivingLicenseNumber;
    private Date drivingLicenseDate;

    // @DocumentReference
    // private Assure assure;

//vehicule
    // @DocumentReference
    // private Vehicule vehicule;
    private String directionFrom;
    private String directionTo;


    private String visibleDamage;

    private String observation;

// //CircumstancesList
//     private List<Boolean> circonstance = new ArrayList<>();

//     private String signatureImage;
//     private String damagePointImage;
//     private String directionImage;


//     private String etat;
//     private String degats;

//     private String imageAv;
//     //private List<String> imageAv = new ArrayList<>();
//     private String imageAp;
//     private String devis;
//     private String facture;


//     private String mode;
//     private String montant;

//     private Date rdvDate;
//     private String rdvLieu;
//     private String rdvNote;

}