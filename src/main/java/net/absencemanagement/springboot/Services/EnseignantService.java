//package net.absencemanagement.springboot.Services;


import jakarta.transaction.Transactional;
import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Models.Etudiant;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import net.absencemanagement.springboot.Repositories.AdministrateurRepository;
import net.absencemanagement.springboot.Repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

//@Service
//public class EnseignantService {
//
//    private final AbsenceRepository absenceRepository;
//
//    @Autowired
//    public EnseignantService(AbsenceRepository absenceRepository) {
//        this.absenceRepository = absenceRepository;
//    }
//
//    public List<Absence> consulterAbsences(Long studentId) {
//        // Assuming you have a method to fetch an Etudiant instance by its ID
//        Etudiant etudiant = etudiantService.findById(studentId);
//        return absenceRepository.findByAbsenceEtudiant(etudiant);
//    }

//    public List<Absence> consulterAbsences(Long studentId) {
//
//        return absenceRepository.findByStudentId(studentId);
//    }
//    public void supprimerAbsence(Long id) {
//        absenceRepository.deleteById(id);
//    }

    // public Absence ajouterAbsence(Absence absence) throws AbsenceAlreadyExistsException {
    // Verify if the absence already exists in the database
    //   Absence existingAbsence = absenceRepository.findByAbsenceId(absence.getAbsenceId());
    //   if (existingAbsence != null) {
    //       throw new AbsenceAlreadyExistsException("Absence already exists with ID: " + absence.getAbsenceId());
    //    }
    //    return absenceRepository.save(absence);
    //}

   // public Absence updateAbsence(Long id, Absence newAbsence) throws AbsenceNotFoundException {
   //     Absence absence = absenceRepository.findById(id).orElseThrow(() -> new AbsenceNotFoundException("Absence not found with ID: " + id));
   //     absence.setAffirmation(newAbsence.getAffirmation());
    //    return absenceRepository.save(absence);
   // }

//    @EntityGraph(attributePaths = {"student"})
//    Absence findAbsenceById(Long id) {
//        return absenceRepository.findById(id).orElseThrow(() -> new AbsenceNotFoundException("Absence not found with ID: " + id));
//    }

//    @Transactional(readOnly = true)
//    public List<Absence> findAbsencesByStudentId(Long studentId) {
//        return absenceRepository.findByStudentId(studentId);
//    }
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public class AbsenceNotFoundException extends RuntimeException {
//        public AbsenceNotFoundException(String message) {
//            super(message);
//        }
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public class AbsenceAlreadyExistsException extends RuntimeException {
//        public AbsenceAlreadyExistsException(String message) {
//            super(message);
//        }
//    }

  //  private final EnseignantRepository enseignantRepository;
   // private final AbsenceRepository absenceRepository;

   // @Autowired
    //public EnseignantService(EnseignantRepository enseignantRepository, AbsenceRepository absenceRepository) {
   //     this.enseignantRepository = enseignantRepository;
    //    this.absenceRepository = absenceRepository;
   // }

   // public List<Absence> consulterAllAbsences() {
    //    return absenceRepository.findAll();
  //  }

   // public List<Absence> consulterAbsences(Long studentId) {
   //     return absenceRepository.findByStudentId(studentId);
   // }

  //  public Absence ajouterAbsence(Absence absence) throws IllegalStateException {
        //verify if the absence is already in the database
   //     List<Absence> absences = absenceRepository.findAll();
    //    int i = 0;
     //   while (i < absences.size()) {
     //       if (absences.get(i).equals(absence)) {
      //          throw new IllegalStateException("Absence already exists");
       //     }
       //     i++;
     //   }
     //   return absenceRepository.save(absence);
    //}

  //  public void supprimerAbsence(Long id) {
      //  absenceRepository.deleteById(id);
   // }

    //public Absence updateAbsence(Absence newAbsence, Long id) throws IllegalStateException {
      //  Absence absence = absenceRepository.findById(id).orElseThrow();
    //    absence.setAffirmation(newAbsence.getAffirmation());
     //   return absenceRepository.save(absence);
   // }



//}