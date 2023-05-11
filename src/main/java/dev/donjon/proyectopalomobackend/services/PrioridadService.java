package dev.donjon.proyectopalomobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.Prioridad;
import dev.donjon.proyectopalomobackend.repositories.PrioridadRepository;

@Service
public class PrioridadService
{
    @Autowired
    PrioridadRepository prioridadRepository;

    public Optional<Prioridad> getPrioridad(Long id)
    {
        return prioridadRepository.findById(id);
    }

    public Optional<Prioridad> getPrioridadPorNivel(Integer nivel)
    {
        return prioridadRepository.findPrioridadByNivel(nivel);
    }

    public List<Prioridad> getPrioridades()
    {
        return prioridadRepository.findAll();
    }
}
