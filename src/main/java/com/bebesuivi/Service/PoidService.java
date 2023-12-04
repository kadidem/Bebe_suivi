package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Poid;
import com.bebesuivi.Modele.Vaccin;
import com.bebesuivi.Repository.PoidRepository;
import com.bebesuivi.Repository.VaccinRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoidService {
    @Autowired
    private PoidRepository poidRepository;
    public Poid createPoid(Poid poid) {
        if (poidRepository.findByPoid(poid.getPoid()) == null) {
            return poidRepository.save(poid);}
        else {
            throw new EntityExistsException("Cet vaccin existe déjà");}}

    public List<Poid> getAllPoid(){

        List<Poid> poids = poidRepository.findAll();
        if (poids.isEmpty())
            throw new NoContentException("Aucun vaccin trouvé");
        return poids;
    }
    public Poid getPoidById(long idPoid){

        Poid poid= poidRepository.findByIdPoid(idPoid);
        if(poid ==null)
            throw new EntityNotFoundException("cet vaccin n'existe pas");
        return poid;
    }

    public Poid editpoid(Poid poid){
        Poid poid1= poidRepository.findByIdPoid(poid.getIdPoid()
        );
        if (poid1 == null)
            throw new EntityNotFoundException("cet vaccin n'existe pas");
        return poidRepository.save(poid);

    }
    public String deletePoidById(long idPoid){

        Poid poid= poidRepository.findByIdPoid(idPoid);
        if (poid == null)
            throw new EntityNotFoundException("Désolé  le vaccin à supprimé n'existe pas");
        poidRepository.delete(poid);
        return "Vaccin Supprimé avec succes";
    }
    public List<Poid> getAllPoidByIdBebe(long idBebe) {

        List<Poid> poid = poidRepository.findByBebe_IdBebe(idBebe);

        if (poid.isEmpty()) {
            throw new NoContentException("Aucun vaccin trouvée pour le bebe avec l'ID : " + idBebe);
        }

        return poid;
    }
}
