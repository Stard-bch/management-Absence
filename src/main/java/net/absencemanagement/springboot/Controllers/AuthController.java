package net.absencemanagement.springboot.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.absencemanagement.springboot.PlayLoad.SigninRequest;
import net.absencemanagement.springboot.Services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn() throws Exception {
        // Create a SigninRequest with test credentials
        SigninRequest request = new SigninRequest("testuser", "testpassword");

        // Call the authentication service with the created request
        return authenticationService.signIn(request);}}
    //    @PostMapping("/signin")
    //    public ResponseEntity<?> signIn(@Valid @RequestBody SigninRequest signinRequest) throws Exception
    //    {
    //        return authenticationService.signIn(signinRequest);
    //    }

   // @Autowired
   // AuthenticationManager authenticationManager;

    //@Autowired
    //UtilisateurRepository userRepository;

    //@Autowired
    //RoleRepository roleRepository;
    //@Autowired
    //PasswordEncoder encoder;

    //@Autowired
    //JwtUtils jwtUtils;
    //@PostMapping("/signin")
    //public ResponseEntity<?> authenticateUser(@Valid @RequestBody SigninRequest loginRequest) {

      //  Authentication authentication = authenticationManager.authenticate(
        //        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        //SecurityContextHolder.getContext().setAuthentication(authentication);
        //String jwt = jwtUtils.generateJwtToken(authentication);

        //UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        //List<String> roles = userDetails.getAuthorities().stream()
          //      .map(item -> item.getAuthority())
            //    .collect(Collectors.toList());

        //return ResponseEntity.ok(new JWTResponse(jwt,
          //      userDetails.getId(),
            //    userDetails.getUsername(),
              //  userDetails.getEmail(),
                //roles));
    //}

