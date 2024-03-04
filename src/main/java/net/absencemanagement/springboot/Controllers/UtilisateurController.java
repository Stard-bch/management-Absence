package net.absencemanagement.springboot.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    @GetMapping("/Etudiant")
    @PreAuthorize("hasRole('ETUDIANT') or hasRole('ENSEIGNANT') or hasRole('ADMINISTRATEUR')")
    public String EtudiantAccess() {
        return "Etudiant Content.";
    }

    @GetMapping("/Enseignant")
    @PreAuthorize("hasRole('ENSEIGNANT')")
    public String EnseignantAccess() {
        return "Enseignant Board.";
    }

    @GetMapping("/Admin")
    @PreAuthorize("hasRole('ADMINISTRATEUR)")
    public String AdminAccess() {
        return "Admin Board.";
    }
}
