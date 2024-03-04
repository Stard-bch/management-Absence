package net.absencemanagement.springboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.absencemanagement.springboot.Enumerations.ERole;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur  {

    @NonNull
    private String genre;
    @NonNull
    private String formation;
    @NonNull
    private String niveau;

    @OneToMany(mappedBy = "absenceEtudiant")
    private Set<Absence> absences = new HashSet<>();

    public Etudiant(String username,  String email, String password, String genre, String formation, String niveau) {
        super(username, email, password);
        this.genre = genre;
        this.formation = formation;
        this.niveau = niveau;
        // Add the role ROLE_ETUDIANT to the user
        this.getRoles().add(new Role(ERole.ROLE_ETUDIANT));

    }

}