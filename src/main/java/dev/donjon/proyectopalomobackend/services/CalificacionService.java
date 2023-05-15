package dev.donjon.proyectopalomobackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.Calificacion;
import dev.donjon.proyectopalomobackend.repositories.CalificacionRepository;

@Service
public class CalificacionService
{
    @Autowired
    private CalificacionRepository calificaionRepository;

    public Optional<Calificacion> getCalificaion(Long id)
    {
        return calificaionRepository.findById(id);
    }
}
