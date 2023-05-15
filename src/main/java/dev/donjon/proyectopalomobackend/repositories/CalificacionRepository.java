package dev.donjon.proyectopalomobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entities.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long>
{
    
}
