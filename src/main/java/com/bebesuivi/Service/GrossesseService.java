package com.bebesuivi.Service;

import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Repository.GrossesseRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

@Service
public class GrossesseService {
    private final GrossesseRepository grossesseRepository;

    public GrossesseService(GrossesseRepository grossesseRepository) {
        this.grossesseRepository = grossesseRepository;
    }
    public Grossesse createGrossesse(Grossesse grossesse) {
        if (grossesseRepository.findById(grossesse.getIdGrossesse()) == null) {
            return grossesseRepository.save(grossesse);}
        else {
            throw new EntityExistsException("Cet email existe déjà");}}
}
