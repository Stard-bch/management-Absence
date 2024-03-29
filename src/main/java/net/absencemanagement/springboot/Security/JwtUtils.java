package net.absencemanagement.springboot.Security;

import io.jsonwebtoken.*;
import net.absencemanagement.springboot.Models.Utilisateur;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import java.util.Date;

@Component
public class JwtUtils {

    private static final Log LOG = LogFactory.getLog(JwtUtils.class);

   // get properties defined in application.properties file
    @Value("${Absence.app.jwt.secret}")
    private String jwtSecret;

    @Value("${Absence.app.jwtExpiration}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){
        Utilisateur userPrincipal = (Utilisateur) authentication.getPrincipal();

        return Jwts.builder().setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
   }
    public String getUsernameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String authToken){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e){
            LOG.error("Invalid JWT signature: {}");
        }catch (MalformedJwtException e) {
            LOG.error("Invalid JWT token: {}");
        }catch (UnsupportedJwtException e) {
            LOG.error("JWT token is unsupported: {}");

        }catch (IllegalArgumentException e) {
            LOG.error("JWT claims string is empty: {}");
        }catch (ExpiredJwtException e) {
            LOG.error("JWT token is expired: {}");
        }
        return false;
    }

}
