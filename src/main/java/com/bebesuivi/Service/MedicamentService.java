package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.MedicamentRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicamentService {
    private MedicamentRepository medicamentRepository;

    public MedicamentService(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }
    public Medicament createMedicament(Medicament medicament) {
        if (medicament.getDateDebut() == null) {
            medicament.setDateDebut(LocalDate.now());
        }
        LocalDate dateFin = medicament.getDateDebut().plusDays(medicament.getNbreDeJour());
        medicament.setDateFin(dateFin);
        if (medicamentRepository.findByNom(medicament.getNom()) == null) {
            return medicamentRepository.save(medicament);}
        else {
            throw new EntityExistsException("Cet medicament existe déjà");}}
    public List<Medicament> getAllMedicament(){

        List<Medicament> medicaments = medicamentRepository.findAll();
        if (medicaments.isEmpty())
            throw new NoContentException("Aucun medicament trouvé");
        return medicaments;
    }
    public Medicament getMedicamentById(long idMedicaement){

        Medicament medicament= medicamentRepository.findByIdMedicament(idMedicaement);
        if(medicament ==null)
            throw new EntityNotFoundException("cet medicament n'existe pas");
        return medicament;
    }

    public Medicament editMedicament(Medicament medicament){
        LocalDate dateFin = medicament.getDateDebut().plusDays(medicament.getNbreDeJour());
        medicament.setDateFin(dateFin);
        Medicament medicament1= medicamentRepository.findByIdMedicament(medicament.getIdMedicament());
        if (medicament1 == null)
            throw new EntityNotFoundException("cet medicament n'existe pas");
        return medicamentRepository.save(medicament);

    }
    public String deleteMedicamentById(long idMedicaement){

        Medicament medicament1= medicamentRepository.findByIdMedicament(idMedicaement);
        if (medicament1 == null)
            throw new EntityNotFoundException("Désolé  le medicament à supprimé n'existe pas");
        medicamentRepository.delete(medicament1);
        return "Medicament Supprimé avec succes";
    }
}
