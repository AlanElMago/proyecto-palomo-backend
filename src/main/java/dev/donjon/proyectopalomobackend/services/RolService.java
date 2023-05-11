package dev.donjon.proyectopalomobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entidades.Rol;
import dev.donjon.proyectopalomobackend.repositories.RolRepository;

@Service
public class RolService
{
    @Autowired
    private RolRepository rolRepository;

    public Optional<Rol> getRol(Long id)
    {
        return rolRepository.findById(id);
    }

    public List<Rol> getRoles()
    {
        return rolRepository.findAll();
    }

    public Rol crearRol(Rol rol)
    {
        return rolRepository.save(rol);
    }

    public List<Rol> crearRoles(List<Rol> roles)
    {
        return rolRepository.saveAll(roles);
    }
}
