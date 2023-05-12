package dev.donjon.proyectopalomobackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>
{
    public List<Rol> findByUsuarios_Id(Long idUsuario);
}
