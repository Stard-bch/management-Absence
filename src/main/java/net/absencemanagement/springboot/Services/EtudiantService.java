package net.absencemanagement.springboot.Services;
import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Models.Etudiant;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import net.absencemanagement.springboot.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private AbsenceRepository absenceRepository;

    public ResponseEntity<?> getAbsencesByStudentId(Long utilisateurid) {
        List<Absence> absences = absenceRepository.findByAbsenceEtudiantUtilisateurid(utilisateurid);
        if (absences.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("There are no absences for this student");
        return ResponseEntity.status(HttpStatus.OK)
                .body(absences);
    }

}

