package dev.donjon.proyectopalomobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.Actividad;
import dev.donjon.proyectopalomobackend.repositories.ActividadRepository;

@Service
public class ActividadService
{
    @Autowired
    private ActividadRepository actividadRepository;

    public Optional<Actividad> getActividad(Long id)
    {
        return actividadRepository.findById(id);
    }

    public List<Actividad> getActividades()
    {
        return actividadRepository.findAll();
    }

    public List<Actividad> getActividadesPorIdUsuario(Long idUsuario)
    {
        return actividadRepository.findByAsesoresAsignados_Id(idUsuario);
    }
}
