package com.bebesuivi.Service;

import com.bebesuivi.Exception.BadRequestException;
import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.GrossesseRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class GrossesseService {
    private final GrossesseRepository grossesseRepository;

    public GrossesseService(GrossesseRepository grossesseRepository) {
        this.grossesseRepository = grossesseRepository;
    }
    int dureeGrossesseSemaines = 40;
    public Grossesse createGrossesse(Grossesse grossesse) {
        System.out.println("weety"+grossesse);

        LocalDate aujourdhui = LocalDate.now();
        LocalDate dateDernierRegle = grossesse.getDateDernierRegle();
        Grossesse dernierGrossesse = grossesseRepository.findFirstByUserIdUserOrderByIdGrossesseDesc(grossesse.getUser().getIdUser());
       if(dernierGrossesse != null ){
           LocalDate dateDernierAccouchement = dernierGrossesse.getDateAcouchement();
           if(dateDernierRegle.isBefore(dateDernierAccouchement)){
               throw new BadRequestException("cette date est dans une date de grossesse");
           }
       }

       if(dateDernierRegle.getYear()<aujourdhui.getYear()-1 || dateDernierRegle.getYear()>aujourdhui.getYear()){
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
