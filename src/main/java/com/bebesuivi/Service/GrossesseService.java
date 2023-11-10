package com.bebesuivi.Service;

import com.bebesuivi.Exception.BadRequestException;
import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Grossesse;
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
    public Grossesse createGrossesse(Grossesse grossesse) {
        int dureeGrossesseSemaines = 40;
        LocalDate dateDernierRegle = grossesse.getDateDernierRegle();
        Grossesse dernierGrossesse = grossesseRepository.findFirstByUserIdUserOrderByIdGrossesseDesc(grossesse.getUser().getIdUser());
        LocalDate dateDernierAccouchement = dernierGrossesse.getDateAcouchement();
        if(dateDernierRegle.isBefore(dateDernierAccouchement)){
            throw new BadRequestException("cette date est dans une date de grossesse");
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
}
