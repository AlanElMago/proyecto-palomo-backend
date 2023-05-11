package dev.donjon.proyectopalomobackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    public Optional<Usuario> findUsuarioByEmail(String email);
}
