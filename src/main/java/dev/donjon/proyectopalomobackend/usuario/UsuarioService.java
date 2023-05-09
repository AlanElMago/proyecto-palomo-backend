package dev.donjon.proyectopalomobackend.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuario(Long id)
    {
        return usuarioRepository.findById(id);
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
