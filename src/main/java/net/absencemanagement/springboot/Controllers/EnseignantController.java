package net.absencemanagement.springboot.Controllers;
import jakarta.validation.Valid;
import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import net.absencemanagement.springboot.Repositories.EnseignantRepository;
import net.absencemanagement.springboot.Services.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enseignant")
public class EnseignantController {

    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping("/all")
    public ResponseEntity<?> allabsences()
    {

        return enseignantService.getAllAbsences();
    }

  //  @GetMapping("get-absence/{id}")
 //   public ResponseEntity<?> absenceById(@PathVariable Long id)
  //  {
      //  return enseignantService.getAbsenceById(id);
   // }

    @PostMapping("/add-absence")
    public ResponseEntity<?> addAbsence(@Valid @RequestBody Absence a)
    {

        return enseignantService.addAbsence(a);
    }
    @DeleteMapping("/remove-absence/{id}")
    public ResponseEntity<?> deleteAbsence(@PathVariable Long id)
    {

        return enseignantService.deleteAbsence(id);
    }

    @PutMapping("/update-absence/{id}")
    public ResponseEntity<?> updateAbsence(@PathVariable Long id, @RequestBody Absence a)
    {
        return enseignantService.updateAbsence(id,a);
    }

}

