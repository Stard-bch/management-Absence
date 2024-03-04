package net.absencemanagement.springboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.absencemanagement.springboot.Enumerations.ERole;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Administrateur extends Utilisateur{
    public Administrateur(String username,  String email, String password) {
        super(username, email, password);
        this.getRoles().add(new Role(ERole.ROLE_ADMINISTRATEUR));

    }

}