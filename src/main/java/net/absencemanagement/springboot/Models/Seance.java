package net.absencemanagement.springboot.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "id_enseignant")
    private Enseignant seanceEnseignant;
    @OneToMany(mappedBy = "absenceSeance")
    private Set<Absence> absences = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "id_module")
    private Module seanceModule;

}
