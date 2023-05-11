package dev.donjon.proyectopalomobackend.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.config.JwtUtils;
import dev.donjon.proyectopalomobackend.entidades.AuthenticationRequest;
import dev.donjon.proyectopalomobackend.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController
{
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = authenticationService.findUserByEmail(request.getEmail());

        if (user != null) {
            return new ResponseEntity<String>(jwtUtils.generateToken(user), HttpStatus.OK);
        }

        return new ResponseEntity<String>("Some error has occured.", HttpStatus.BAD_REQUEST);
    }
}
