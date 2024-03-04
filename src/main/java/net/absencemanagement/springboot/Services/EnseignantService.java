package net.absencemanagement.springboot.Services;


import jakarta.transaction.Transactional;
import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Models.Etudiant;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import net.absencemanagement.springboot.Repositories.AdministrateurRepository;
import net.absencemanagement.springboot.Repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private AbsenceRepository absenceRepository;
    public ResponseEntity<?> getAllAbsences()
    {
        List<Absence> absences=absenceRepository.findAll();
        if(absences.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("There is no absences");
        return ResponseEntity.status(HttpStatus.OK)
                .body(absences);
    }

   // public ResponseEntity<?> getAbsenceById(Long absenceId)
  //  {
   //     Optional<Absence> result=absenceRepository.findById(absenceId);
   //     if(result.isPresent())
      //      return ResponseEntity.status(HttpStatus.OK)
      //              .body(result.get());
     //   return ResponseEntity.status(HttpStatus.BAD_REQUEST)
      //          .body("Absence not found");
   // }

    public ResponseEntity<?> addAbsence(Absence a)
    {
        List<Absence> listeabsences=absenceRepository.findAll();
        if(listeabsences.contains(a))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("This absence already exists");
        Absence result=absenceRepository.save(a);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

    public ResponseEntity<?> deleteAbsence(Long id)
    {
        Optional<Absence> result=absenceRepository.findById(id);
        if(result.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Absence not found");

        absenceRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Absence successufly deleted");
    }

    public ResponseEntity<?> updateAbsence(Long id,Absence aNew)
    {
        Optional<Absence> result=absenceRepository.findById(id);
        if(result.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Absence not found");
        Absence abs= result.get();
        abs.setAffirmation(aNew.getAffirmation());
        Absence a1=absenceRepository.save(abs);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(a1);
    }


}