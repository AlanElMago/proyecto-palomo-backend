package dev.donjon.proyectopalomobackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.donjon.proyectopalomobackend.entities.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long>
{
    public List<Actividad> findByAsesoresAsignados_Id(Long idUsuario);
}
