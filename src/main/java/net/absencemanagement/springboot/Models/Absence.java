package net.absencemanagement.springboot.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long absenceId;
    @NonNull
    private String Affirmation;

    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant absenceEtudiant;
    @ManyToOne
    @JoinColumn(name = "id_seance")
    private Seance absenceSeance;


}
