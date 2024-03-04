package net.absencemanagement.springboot.Services;

import net.absencemanagement.springboot.PlayLoad.JWTResponse;
import net.absencemanagement.springboot.PlayLoad.SigninRequest;
import net.absencemanagement.springboot.Security.JwtUtils;
import net.absencemanagement.springboot.Security.UserDetailsImpl;
import net.absencemanagement.springboot.Security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> signIn(SigninRequest signinRequest) throws Exception {
        //get the authentication object using given credentials (username and password)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signinRequest.getUsername(),
                        signinRequest.getPassword()
                )
        );
        //set the authentication object in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //generate the jwt token
        String jwtToken = jwtUtils.generateJwtToken(authentication);
        //get the user details
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        //get user roles
        List<String> roles = userDetails.getAuthorities().stream()
                .map(r -> r.getAuthority())
                .toList();
        //get user id and email directly from UserDetailsImpl
        Long userId = userDetails.getId();
        String userEmail = userDetails.getEmail();
        return ResponseEntity.ok().body(new JWTResponse(
                jwtToken, userId, userDetails.getUsername(), userEmail, roles)
        );
    }
}
