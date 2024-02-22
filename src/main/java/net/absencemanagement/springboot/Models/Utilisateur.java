package net.absencemanagement.springboot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "utilisateur_type")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateur_id;
    @NonNull
    @Column(name = "nom")
    private String nom;

    @NonNull
    @Column(name = "prenom")
    private String prenom;

    @NonNull
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // Getters and setters for password

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}