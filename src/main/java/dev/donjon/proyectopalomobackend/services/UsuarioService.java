package dev.donjon.proyectopalomobackend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entidades.Usuario;
import dev.donjon.proyectopalomobackend.repositories.UsuarioRepository;

@Service
public class UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuario(Long id)
    {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> getUsuarioPorEmail(String email)
    {
        return usuarioRepository.findUsuarioByEmail(email);
    }

    public List<Usuario> getUsuarios()
    {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> crearUsuarios(List<Usuario> usuarios)
    {
        return usuarioRepository.saveAll(usuarios);
    }
}