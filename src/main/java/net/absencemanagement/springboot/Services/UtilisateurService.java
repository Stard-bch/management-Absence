//package net.absencemanagement.springboot.Services;
//
//import net.absencemanagement.springboot.Models.Utilisateur;
//import net.absencemanagement.springboot.Repositories.UtilisateurRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

//@Service
//public class UtilisateurService {
//
//    @Autowired
//    private UtilisateurRepository utilisateurRepository;
//
//    // Authenticate Utilisateur
//    public boolean authenticateUtilisateur(String email, String password) {
//        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
//        if (utilisateur != null && utilisateur.checkPassword(password)) {
//            return true;
//        }
//        return false;
//    }
//}