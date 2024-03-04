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

public class Enseignant extends Utilisateur  {
    @OneToMany(mappedBy = "seanceEnseignant")
    private Set<Seance> seances = new HashSet<>();
    public Enseignant(String username,  String email, String password) {
        super(username, email, password);
        this.getRoles().add(new Role(ERole.ROLE_ENSEIGNANT));

    }



}