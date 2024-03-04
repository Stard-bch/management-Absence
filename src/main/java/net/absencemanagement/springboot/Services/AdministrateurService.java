package net.absencemanagement.springboot.Services;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Repositories.AdministrateurRepository;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {


    @Autowired
    private  AdministrateurRepository administrateurRepository;

    @Autowired
    private  AbsenceRepository absenceRepository;


  //  public List<Absence> consulterAbsences() {

     //   return absenceRepository.findAll();
   // }

    public ResponseEntity<?> consulterAbsences()
    {
        List<Absence> absences=absenceRepository.findAll();
        if(absences.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("There is no absences");
        return ResponseEntity.status(HttpStatus.OK)
                .body(absences);
    }
}