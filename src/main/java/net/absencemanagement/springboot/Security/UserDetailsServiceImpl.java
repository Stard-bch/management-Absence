package net.absencemanagement.springboot.Security;

import net.absencemanagement.springboot.Models.Utilisateur;
import net.absencemanagement.springboot.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtilisateurRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepository.findByUsername(username)
              .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

       return UserDetailsImpl.build(user);
    }


}
