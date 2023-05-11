package dev.donjon.proyectopalomobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>
{
    
}
