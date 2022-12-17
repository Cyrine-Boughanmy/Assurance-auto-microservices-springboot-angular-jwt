package soc.constat.controllers;

import soc.constat.models.Constat;
import soc.constat.models.Notification;
import soc.constat.repositories.ConstatRepository;
import soc.constat.services.ConstatServiceImpl;
import soc.constat.services.Dto.ConstatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/constat")
public class ConstatController {

    @Autowired
    ConstatServiceImpl constatService;

    @Autowired
    ConstatRepository constatRepository;

    @Autowired
    NotificationController notificationController;

    @PostMapping(value = "/Add")
    public Constat addConstat(@RequestBody ConstatDTO constatDTO){
        Notification notifications =new Notification(0,"");
        notifications.setMessage( " Nouveau constat ");
        notificationController.getNotification(notifications);

        return constatService.addConstat(constatDTO) ;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Constat> getAllCreationidm() {
        List<Constat> list = constatService.RetreiveAllConstat();
        return list;
    }

    @GetMapping("/findConstatById/{idc}")
    @ResponseBody
    public Constat findConstatById(@PathVariable ("idc") String idc) {

        return constatService.findConstatByIdc(idc);
    }

    @PatchMapping("/etat1/{idc}")
    public ResponseEntity<Constat> etat1(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente Photos Avant RÃ©paration");

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/etat2/{idc}")
    public ResponseEntity<Constat> etat2(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente de Validation Devis");

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/etat3/{idc}")
    public ResponseEntity<Constat> etat3(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente Photos AprÃ©s RÃ©paration");

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/etat4/{idc}")
    public ResponseEntity<Constat> etat4(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente de Validation Facture");

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/etat5/{idc}")
    public ResponseEntity<Constat> etat5(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente Remboursement");

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/etat6/{idc}")
    public ResponseEntity<Constat> etat6(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("Dossier CloturÃ©");

        final Constat updatedConstat = constatRepository.save(cst);
        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/faible/{idc}")
    public ResponseEntity<Constat> faibleDegats(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente de Validation");
        cst.setDegats("DÃ©gats Faibles");
        final Constat updatedConstat = constatRepository.save(cst);
        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/eleve/{idc}")
    public ResponseEntity<Constat> eleveDegats(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("En Attente d'Affectation Expert");
        cst.setDegats("DÃ©gats ElevÃ©s");
        final Constat updatedConstat = constatRepository.save(cst);
        return ResponseEntity.ok(updatedConstat);
    }

    @GetMapping(path = "/findConstatDF")
    public List<Constat> findConstatDF() {
        return constatService.findConstatDF();
    }

    @GetMapping(path = "/findConstatDE")
    public List<Constat> findConstatDE() {
        return constatService.findConstatDE();
    }

    @PutMapping(path = "/affecterExpert/{idc}/{id}")
    public void affecterExpert (@PathVariable("idc") String idc , @PathVariable("id") String id){

        constatService.affecterExpert(idc , id);
    }



    @PatchMapping("/etatEx/{idc}")
    public ResponseEntity<Constat> etatEx(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setEtat("Expert AffectÃ©");

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/av/{idc}")
    public ResponseEntity<Constat> addAv(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setImageAv(constat.getImageAv());

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/ap/{idc}")
    public ResponseEntity<Constat> addAp(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setImageAp(constat.getImageAp());

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/devis/{idc}")
    public ResponseEntity<Constat> addDevis(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setDevis(constat.getDevis());

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PatchMapping("/facture/{idc}")
    public ResponseEntity<Constat> addFacture(
            @PathVariable(value = "idc") String idc,
            @Valid @RequestBody Constat constat) {
        Constat cst = constatRepository.findById(idc).orElseThrow();

        cst.setFacture(constat.getFacture());

        final Constat updatedConstat = constatRepository.save(cst);

        return ResponseEntity.ok(updatedConstat);
    }

    @PutMapping("/up/{idc}")
    public ResponseEntity<Constat> updateConstat(@PathVariable (value = "idc") String idc, @RequestBody Constat constat){
        Constat cst = constatRepository.findById(idc)
                .orElseThrow(() -> new ResourceNotFoundException("Constat not exist with id :" + idc));

        cst.setTypee(constat.getTypee());
        cst.setDate(constat.getDate());
        cst.setLat(constat.getLat());
        cst.setLng(constat.getLng());
        cst.setInjury(constat.getInjury());
        cst.setMaterieldamage(constat.getMaterieldamage());
        cst.setSketchImage(constat.getSketchImage());
        cst.setWitnessName(constat.getWitnessName());
        cst.setAdress(constat.getAdress());
        cst.setPhone(constat.getPhone());
        cst.setType(constat.getType());
        cst.setFirstnameC(constat.getFirstnameC());
        cst.setLastnameC(constat.getLastnameC());
        cst.setAdressC(constat.getAdressC());
        cst.setPhoneC(constat.getPhoneC());
        cst.setDrivingLicenseNumber(constat.getDrivingLicenseNumber());
        cst.setDrivingLicenseDate(constat.getDrivingLicenseDate());
        cst.setAssure(constat.getAssure());
        cst.setVehicule(constat.getVehicule());
        cst.setDirectionFrom(constat.getDirectionFrom());
        cst.setDirectionTo(constat.getDirectionTo());
        cst.setVisibleDamage(constat.getVisibleDamage());
        cst.setObservation(constat.getObservation());
        cst.setCirconstance(constat.getCirconstance());
        cst.setSignatureImage(constat.getSignatureImage());
        cst.setDamagePointImage(constat.getDamagePointImage());
        cst.setDirectionImage(constat.getDirectionImage());
        cst.setEtat(constat.getEtat());
        cst.setDegats(constat.getDegats());
        cst.setImageAv(constat.getImageAv());
        cst.setImageAp(constat.getImageAp());
        cst.setDevis(constat.getDevis());
        cst.setFacture(constat.getFacture());
        cst.setMontant(constat.getMontant());
        cst.setMode(constat.getMode());
        cst.setRdvDate(constat.getRdvDate());
        cst.setRdvLieu(constat.getRdvLieu());
        cst.setRdvNote(constat.getRdvNote());

        Constat updateConstat = constatRepository.save(cst);
        return ResponseEntity.ok(updateConstat);
    }

    @DeleteMapping("/del/{idc}")
    public ResponseEntity<Constat> deleteEmployee(@PathVariable(value = "idc") String idc){
        Constat constat= constatRepository.findById(idc).orElseThrow(
                ()->new ResourceNotFoundException("constat not found"+idc));
        constatRepository.delete(constat);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/findConstatExpert")
    public List<Constat> findConstatExpert() {
        return constatService.findConstatExpert();
    }

    @GetMapping(path = "/findConstatCloturÃ©")
    public List<Constat> findConstatCloturÃ©() {
        return constatService.findConstatCloturÃ©();
    }

}


