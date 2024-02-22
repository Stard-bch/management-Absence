package net.absencemanagement.springboot.Repositories;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByAbsenceEtudiant(Utilisateur etudiant);





//    @Query("SELECT a FROM Absence a WHERE a.student.id = :studentId")
//    List<Absence> findByStudentId(@Param("studentId") Long studentId);
//
//    @Query("SELECT a FROM Absence a WHERE a.student.id IN (:studentIds)")
//    List<Absence> findByStudentIds(@Param("studentIds") List<Long> studentIds);
}


