package net.absencemanagement.springboot.Repositories;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
}
