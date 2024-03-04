package net.absencemanagement.springboot.Repositories;

import net.absencemanagement.springboot.Models.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.username = ?1")
    Optional<Utilisateur> findByUsername(String username);
}