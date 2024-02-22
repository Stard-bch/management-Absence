package net.absencemanagement.springboot.Repositories;

import net.absencemanagement.springboot.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByEmail(String email);

    Optional<Etudiant> findById(Long id);
}
