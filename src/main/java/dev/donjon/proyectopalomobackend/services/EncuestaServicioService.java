package dev.donjon.proyectopalomobackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.EncuestaServicio;
import dev.donjon.proyectopalomobackend.repositories.EncuestaServicioRepository;

@Service
public class EncuestaServicioService
{
    @Autowired
    private EncuestaServicioRepository encuestaServicioRepository;

    public Optional<EncuestaServicio> getEncuestaServicio(Long id)
    {
        return encuestaServicioRepository.findById(id);
    }
}
