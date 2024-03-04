package net.absencemanagement.springboot.Models;


import jakarta.persistence.*;
import lombok.*;
import net.absencemanagement.springboot.Enumerations.ERole;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="roles")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Include
    private ERole name;
    @ManyToMany(mappedBy = "roles")
    private Set<Utilisateur> users = new HashSet<>();

    public static final ERole ROLE_ETUDIANT = ERole.ROLE_ETUDIANT;

    public static final ERole ROLE_ENSEIGNANT = ERole.ROLE_ENSEIGNANT;
    public static final ERole ROLE_ADMINISTRATEUR= ERole.ROLE_ADMINISTRATEUR;


}
