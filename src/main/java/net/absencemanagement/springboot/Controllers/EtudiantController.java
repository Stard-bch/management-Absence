package net.absencemanagement.springboot.Controllers;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    private EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/absences/{id}")
    public ResponseEntity<List<Absence>> getAbsencesByEtudiantId(@PathVariable Long id) {
        List<Absence> absences = etudiantService.getAbsencesByEtudiantId(id);
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }
}