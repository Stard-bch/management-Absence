package net.absencemanagement.springboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

}