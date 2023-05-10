package dev.donjon.proyectopalomobackend.entidades.rol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
