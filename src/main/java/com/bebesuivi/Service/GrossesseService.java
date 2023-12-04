package com.bebesuivi.Service;

import com.bebesuivi.Exception.BadRequestException;
import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.GrossesseRepository;
import com.bebesuivi.Repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrossesseService {


    @Autowired
    private  GrossesseRepository grossesseRepository;


    @Autowired
    public GrossesseService(GrossesseRepository grossesseRepository) {
        this.grossesseRepository = grossesseRepository;

    }    int dureeGrossesseSemaines = 40;
    public Grossesse createGrossesse(Grossesse grossesse) {
        System.out.println("weety"+grossesse);

        LocalDate aujourdhui = LocalDate.now();
        LocalDate dateDernierRegle = grossesse.getDateDernierRegle();
        Grossesse dernierGrossesse = grossesseRepository.findFirstByUserIdUserOrderByIdGrossesseDesc(grossesse.getUser().getIdUser());
       if(dernierGrossesse != null ){
           LocalDate dateDernierAccouchement = dernierGrossesse.getDateAcouchement();
           System.out.println("====================="+dateDernierAccouchement);
           if(dateDernierRegle.isBefore(dateDernierAccouchement)){
              throw new BadRequestException("cette date est dans une date de grossesse");
           }
       }
if (dateDernierRegle.isAfter(aujourdhui)){
    throw new BadRequestException("la date de dernier regle est dans le future");
}
       if(dateDernierRegle.getYear()<aujourdhui.getYear()-2 || dateDernierRegle.getYear()>aujourdhui.getYear()){
           throw new BadRequestException("la date de dernier regle est invalide");
       }

        LocalDate dateAcouchement = grossesse.getDateDernierRegle().plusWeeks(dureeGrossesseSemaines);
        grossesse.setDateAcouchement(dateAcouchement);

        if (grossesse.getDateAcouchement().isBefore(grossesse.getDateDernierRegle())) {
            throw new IllegalArgumentException("La date d'accouchement prévue ne peut pas être avant la date de dernier regle");
        }
        if (grossesseRepository.existsByDateDernierRegle(grossesse.getDateDernierRegle())) {
            throw new EntityExistsException("Une grossesse avec la même date de début existe déjà");
        }

        else {
            return grossesseRepository.save(grossesse);
        }
    }
    public Grossesse getGrossesseById(long idGrossesse){

        Grossesse grossesse= grossesseRepository.findByIdGrossesse(idGrossesse);
        if(grossesse ==null)
            throw new EntityNotFoundException("cette grossesse n'existe pas");
        return grossesse;
    }
    public List<Grossesse> getAllGrossesse(){

        List<Grossesse> grossesses = grossesseRepository.findAll();
        if (grossesses.isEmpty())
            throw new NoContentException("Aucune grossesse trouvée");

        return grossesses;
    }
    public List<Grossesse> getAllGrossesseByIdUser(long idUser) {

        List<Grossesse> grossesses = grossesseRepository.findByUser_IdUser(idUser);

        if (grossesses.isEmpty()) {
            throw new NoContentException("Aucune grossesse trouvée pour l'utilisateur avec l'ID : " + idUser);
        }

        return grossesses;
    }
    public Grossesse getGrossessesEnCours(long userId) {

        LocalDate currentDate = LocalDate.now();
        Grossesse currentGrossesse = grossesseRepository.findByUserIdUserAndDateAcouchementIsAfter(userId,currentDate);
        if (currentGrossesse == null){
            throw new NoContentException("Aucun grossesse en cours");
        }
        return currentGrossesse;
    }
    public Grossesse editGrossesse(Grossesse grossesse){
        LocalDate dateAcouchement = grossesse.getDateDernierRegle().plusWeeks(dureeGrossesseSemaines);
        grossesse.setDateAcouchement(dateAcouchement);
        Grossesse grossesse1= grossesseRepository.findByIdGrossesse(grossesse.getIdGrossesse());
        if (grossesse1 == null)
            throw new EntityNotFoundException("cet medicament n'existe pas");
        return grossesseRepository.save(grossesse);

    }
    public String deleteGrossesseById(long idGrossesse){

            Grossesse grossesse= grossesseRepository.findByIdGrossesse(idGrossesse);
        if (grossesse == null)
            throw new EntityNotFoundException("Désolé  le medicament à supprimé n'existe pas");
        grossesseRepository.delete(grossesse);
        return "Medicament Supprimé avec succes";
    }
}
