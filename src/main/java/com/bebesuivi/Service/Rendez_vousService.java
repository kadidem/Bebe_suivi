package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Bebe;
import com.bebesuivi.Modele.Rendez_vous;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.Rendez_vousRepository;
import com.bebesuivi.Repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Rendez_vousService {
    private final Rendez_vousRepository rendez_vousRepository;
    @Autowired
    public Rendez_vousService(Rendez_vousRepository rendez_vousRepository) {
        this.rendez_vousRepository = rendez_vousRepository;
    }
    public Rendez_vous createRdv(Rendez_vous rendez_vous) {
        if (rendez_vousRepository.findBydateRdv(rendez_vous.getDateRdv()) == null) {
            return rendez_vousRepository.save(rendez_vous);}
        else {
            throw new EntityExistsException("Cet email existe déjà");}}
    public List<Rendez_vous> getAllRdv(){

        List<Rendez_vous> rendez_vous = rendez_vousRepository.findAll();
        if (rendez_vous.isEmpty())
            throw new NoContentException("Aucun utilisateur trouvé");
        return rendez_vous;
    }
    public Rendez_vous getRdvById(long idRdv){

        Rendez_vous rendezVous= rendez_vousRepository.findByIdRdv(idRdv);
        if(rendezVous ==null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return rendezVous;
    }

    public Rendez_vous editRdv(Rendez_vous rendezVous){
        Rendez_vous rendez_vous= rendez_vousRepository.findByIdRdv(rendezVous.getIdRdv());
        if (rendez_vous == null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return rendez_vousRepository.save(rendez_vous);

    }
    public String deleteRdvById(long idRdv){

        Rendez_vous rendez_vous= rendez_vousRepository.findByIdRdv(idRdv);
        if (rendez_vous == null)
            throw new EntityNotFoundException("Désolé  le medicament à supprimé n'existe pas");
        rendez_vousRepository.delete(rendez_vous);
        return "Medicament Supprimé avec succes";
    }
}
