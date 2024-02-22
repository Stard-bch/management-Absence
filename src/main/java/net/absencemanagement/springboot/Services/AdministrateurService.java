package net.absencemanagement.springboot.Services;

import net.absencemanagement.springboot.Models.Absence;
import net.absencemanagement.springboot.Repositories.AdministrateurRepository;
import net.absencemanagement.springboot.Repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrateurService {

    private  AdministrateurRepository administrateurRepository;
    private  AbsenceRepository absenceRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository, AbsenceRepository absenceRepository) {
        this.administrateurRepository = administrateurRepository;
        this.absenceRepository = absenceRepository;
    }

    public List<Absence> consulterAbsences() {

        return absenceRepository.findAll();
    }
}