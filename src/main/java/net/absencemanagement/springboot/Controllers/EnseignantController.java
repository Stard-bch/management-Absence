//package net.absencemanagement.springboot.Controllers;
//
//import jakarta.validation.Valid;
//import net.absencemanagement.springboot.Models.Absence;
//import net.absencemanagement.springboot.Repositories.EnseignantRepository;
//import net.absencemanagement.springboot.Services.AdministrateurService;
//import net.absencemanagement.springboot.Services.EnseignantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/enseignant")
//public class EnseignantController {
//
//    private final EnseignantService enseignantService;
//
//    @Autowired
//    public EnseignantController(EnseignantService enseignantService) {
//        this.enseignantService = enseignantService;
//    }
//
//    @GetMapping("/absences/{studentId}")
//    public List<Absence> consulterAbsences(@PathVariable Long studentId) {
//        return enseignantService.consulterAbsences(studentId);
//    }
//    @GetMapping("/{studentId}")
//    public List<Absence> consulterAbsences(@PathVariable Long studentId) {
//        return enseignantService.consulterAbsences(studentId);
//    }

//    @GetMapping("/absences")
//    public List<Absence> consulterAllAbsences(){
//        return enseignantService.consulterAllAbsences();
//    }
//
//    @DeleteMapping("/absence/{id}")
//    public void SupprimerAbsence(@PathVariable Long id) {
//        enseignantService.supprimerAbsence(id);
//    }

    //    @PostMapping("/absence")
//    public Absence ajouterAbsence(@RequestBody @Valid Absence absence) throws IllegalStateException {
//        return enseignantService.ajouterAbsence(absence);
//    }

//    @PutMapping("/absence/{id}")
//    public Absence updateAbsence(@PathVariable Long id, @RequestBody @Valid Absence absence) throws IllegalStateException {
//        return enseignantService.updateAbsence(absence, id);
//    }
//}
