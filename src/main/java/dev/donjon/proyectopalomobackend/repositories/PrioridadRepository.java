package dev.donjon.proyectopalomobackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entities.Prioridad;

@Repository
public interface PrioridadRepository extends JpaRepository<Prioridad, Long>
{
    public Optional<Prioridad> findPrioridadByNivel(Short nivel);
}
