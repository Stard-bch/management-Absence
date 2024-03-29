package net.absencemanagement.springboot.Controllers;


import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Services.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/administrateur")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;


    //@GetMapping("/absences")
   // public List<Absence> consulterAbsences(){

     //   return administrateurService.consulterAbsences();
    //}

    @GetMapping("/absences")
    public ResponseEntity<?> Allabsences()
    {

        return administrateurService.consulterAbsences();
    }

}
