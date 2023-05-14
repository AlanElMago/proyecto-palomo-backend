package dev.donjon.proyectopalomobackend.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.AuthenticationRequest;
import dev.donjon.proyectopalomobackend.entities.Usuario;
import dev.donjon.proyectopalomobackend.jwt.JwtUtils;
import dev.donjon.proyectopalomobackend.services.AuthenticationService;
import dev.donjon.proyectopalomobackend.services.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController
{
    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;
    private final UsuarioService usuarioService;
    private final JwtUtils jwtUtils;

    @GetMapping("/authenticate")
    public ResponseEntity<String> authenticate()
    {
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = authenticationService.findUserByEmail(request.getEmail());
        final Usuario usuario = usuarioService.getUsuarioPorEmail(user.getUsername()).get();

        return new ResponseEntity<String>(jwtUtils.generateToken(user, usuario), HttpStatus.OK);
    }
}
