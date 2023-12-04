package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Bebe;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.BebeRepository;
import com.bebesuivi.Repository.GrossesseRepository;
import com.bebesuivi.Repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BebeService {
   @Autowired
    private  BebeRepository bebeRepository;
   @Autowired
    private GrossesseRepository grossesseRepository;

    public Bebe createBebe(Bebe bebe) {
        if (bebeRepository.findByNomPrenom(bebe.getNomPrenom()) == null) {
            return bebeRepository.save(bebe);}
//       LocalDate naissance = bebe.getDateNaissance();
        else {
            throw new EntityExistsException("Cet email existe déjà");}}
    public List<Bebe> getAllBebe(){

        List<Bebe> bebes = bebeRepository.findAll();
        if (bebes.isEmpty())
            throw new NoContentException("Aucun utilisateur trouvé");
        return bebes;
    }
    public List<Bebe> getAllBebeByUser (long idUser){
        List<Grossesse> listgrossesses =grossesseRepository.findByUser_IdUser(idUser);
        List<Bebe> bebelist = new ArrayList<>();
        for (Grossesse grossesse : listgrossesses){
            bebelist.addAll(grossesse.getBebeList());
        }
        return bebelist;
    }
    public Bebe getBebeById(long idBebe){

        Bebe bebe= bebeRepository.findByIdBebe(idBebe);
        if(bebe ==null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return bebe;
    }


    public Bebe editBebe(Bebe bebe){
        Bebe bebe1= bebeRepository.findByIdBebe(bebe.getIdBebe());
        if (bebe1 == null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return bebeRepository.save(bebe);

    }
    public String deleteBebeById(long idBebe){

        Bebe bebe= bebeRepository.findByIdBebe(idBebe);
        if (bebe == null)
            throw new EntityNotFoundException("Désolé  le medicament à supprimé n'existe pas");
        bebeRepository.delete(bebe);
        return "Medicament Supprimé avec succes";
    }
}
