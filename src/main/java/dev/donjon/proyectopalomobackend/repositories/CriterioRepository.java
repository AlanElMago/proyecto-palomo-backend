package dev.donjon.proyectopalomobackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entities.Criterio;

@Repository
public interface CriterioRepository extends JpaRepository<Criterio, Long>
{
    
}
