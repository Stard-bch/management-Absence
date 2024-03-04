package net.absencemanagement.springboot.Controllers;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    @Autowired

    private EtudiantService etudiantService;


    @GetMapping("/get-absences/{studentId}")
    public ResponseEntity<?> absencesByStudentId(@PathVariable Long utilisateurid) {
        return etudiantService.getAbsencesByStudentId(utilisateurid);
    }

}