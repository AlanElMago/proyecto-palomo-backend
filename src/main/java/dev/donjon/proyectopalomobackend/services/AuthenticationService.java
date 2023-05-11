package dev.donjon.proyectopalomobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.Rol;
import dev.donjon.proyectopalomobackend.entities.Usuario;
import dev.donjon.proyectopalomobackend.repositories.RolRepository;
import dev.donjon.proyectopalomobackend.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService
{
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UserDetails findUserByEmail(String email)
    {
        Optional<Usuario> OptionalUsuario = usuarioRepository.findUsuarioByEmail(email);

        if (!OptionalUsuario.isPresent())
            throw new UsernameNotFoundException("El usuario no existe");

        Usuario usuario = OptionalUsuario.get();
        List<Rol> roles = rolRepository.findByUsuarios_Id(usuario.getId());

        usuario.setRoles(roles);

        List<GrantedAuthority> autoridades =
                usuario
                    .getRoles()
                    .stream()
                    .map(r -> (GrantedAuthority) new SimpleGrantedAuthority("ROLE_" + r.getNombre()))
                    .toList();

        return User.builder()
            .username(usuario.getEmail())
            .password(usuario.getContrasena())
            .authorities(autoridades)
            .build();
    }
}
