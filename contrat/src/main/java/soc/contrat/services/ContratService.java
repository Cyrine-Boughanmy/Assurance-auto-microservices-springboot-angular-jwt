package soc.contrat.services;

import soc.contrat.models.Contrat;
import soc.contrat.services.Dto.ContratDto;
import soc.contrat.services.Dto.ResponseDto;

import java.util.List;
public interface ContratService {

    public Contrat addContrat(ContratDto contratDTO);
    public List<Contrat> RetreiveAllContrat();
    public Contrat findByNum(String num);
    public ResponseDto getContrat(String num);

}
