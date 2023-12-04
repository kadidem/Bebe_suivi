package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Modele.Vaccin;
import com.bebesuivi.Repository.UserRepository;
import com.bebesuivi.Repository.VaccinRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinService {
    @Autowired
    private VaccinRepository vaccinRepository;
    public Vaccin createVaccin(Vaccin vaccin) {
        if (vaccinRepository.findByNom(vaccin.getNom()) == null) {
            return vaccinRepository.save(vaccin);}
        else {
            throw new EntityExistsException("Cet vaccin existe déjà");}}

    public List<Vaccin> getAllVaccin(){

        List<Vaccin> vaccins = vaccinRepository.findAll();
        if (vaccins.isEmpty())
            throw new NoContentException("Aucun vaccin trouvé");
        return vaccins;
    }
    public Vaccin getVaccinById(long idVaccin){

        Vaccin vaccin= vaccinRepository.findByIdVaccin(idVaccin);
        if(vaccin ==null)
            throw new EntityNotFoundException("cet vaccin n'existe pas");
        return vaccin;
    }

    public Vaccin editvaccin(Vaccin vaccin){
        Vaccin vaccin1= vaccinRepository.findByIdVaccin(vaccin.getIdVaccin());
        if (vaccin1 == null)
            throw new EntityNotFoundException("cet vaccin n'existe pas");
        return vaccinRepository.save(vaccin);

    }
    public String deleteVaccinById(long idVaccin){

        Vaccin vaccin= vaccinRepository.findByIdVaccin(idVaccin);
        if (vaccin == null)
            throw new EntityNotFoundException("Désolé  le vaccin à supprimé n'existe pas");
        vaccinRepository.delete(vaccin);
        return "Vaccin Supprimé avec succes";
    }
    public List<Vaccin> getAllVaccinByIdBebe(long idBebe) {

        List<Vaccin> vaccin = vaccinRepository.findByBebe_IdBebe(idBebe);

        if (vaccin.isEmpty()) {
            throw new NoContentException("Aucun vaccin trouvée pour le bebe avec l'ID : " + idBebe);
        }

        return vaccin;
    }
}
