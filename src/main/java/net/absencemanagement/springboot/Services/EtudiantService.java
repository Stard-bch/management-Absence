package net.absencemanagement.springboot.Services;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Models.Etudiant;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import net.absencemanagement.springboot.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final AbsenceRepository absenceRepository;
    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(AbsenceRepository absenceRepository, EtudiantRepository etudiantRepository) {
        this.absenceRepository = absenceRepository;
        this.etudiantRepository = etudiantRepository;
    }

    public List<Absence> consulterAbsences(Long studentId) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(studentId);
        if (etudiantOptional.isPresent()) {
            Etudiant etudiant = etudiantOptional.get();
            return absenceRepository.findByAbsenceEtudiant(etudiant);
        } else {
            // Handle the case where no Etudiant with the given ID is found
            throw new IllegalArgumentException("No student found with ID: " + studentId);
        }
    }

//     Authenticate Etudiant
  //  public boolean authenticateEtudiant(String email, String password) {
   //     Etudiant etudiant = etudiantRepository.findByEmail(email);
  //      if (etudiant != null && etudiant.getPassword().equals(password)) {
   //         return true;
   //     }
   //     return false;
   // }

    // Get Etudiant by ID
//    public Optional<Etudiant> findEtudiantById(Long id)
//    {
//        return etudiantRepository.findById(id);
//    }
//    public Etudiant getEtudiantById(Long id) {
//        return etudiantRepository.findById(id).orElse(null);
//    }

    // Retrieve absences for Etudiant
//    public List<Absence> getAbsencesEtudiant(Long etudiantId) {
//        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
//        return etudiant.getAbsences();
//    }
//}
//    public List<Absence> getAbsencesByEtudiantId(Long id) {
//        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(id);
//        if (etudiantOptional.isPresent()) {
//            Etudiant etudiant = etudiantOptional.get();
//            return new ArrayList<>(etudiant.getAbsences());
//        }
//        return null;
//    }


}

