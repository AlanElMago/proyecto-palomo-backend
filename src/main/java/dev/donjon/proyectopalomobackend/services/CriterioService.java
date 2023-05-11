package dev.donjon.proyectopalomobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.Criterio;
import dev.donjon.proyectopalomobackend.repositories.CriterioRepository;

@Service
public class CriterioService
{
    @Autowired
    private CriterioRepository criterioRepository;

    public Optional<Criterio> getCriterio(Long id)
    {
        return criterioRepository.findById(id);
    }

    public List<Criterio> getCriterios()
    {
        return criterioRepository.findAll();
    }
}
