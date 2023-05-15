package dev.donjon.proyectopalomobackend.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donjon.proyectopalomobackend.entities.Actividad;
import dev.donjon.proyectopalomobackend.entities.Prioridad;
import dev.donjon.proyectopalomobackend.entities.Usuario;
import dev.donjon.proyectopalomobackend.repositories.ActividadRepository;
import dev.donjon.proyectopalomobackend.repositories.PrioridadRepository;
import dev.donjon.proyectopalomobackend.repositories.UsuarioRepository;

@Service
public class ActividadService
{
    @Autowired
    private ActividadRepository actividadRepository;
    @Autowired
    private PrioridadRepository prioridadRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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

    public Actividad crearActividad(Actividad actividad)
    {
        return actividadRepository.save(actividad);
    }

    public Actividad actualizarActividad(Actividad actividad)
    {
        ArrayList<Long> idsAsesoresAsignados = new ArrayList<>();
        Prioridad prioridad = prioridadRepository.findById(actividad.getPrioridad().getId()).get();
        
        actividad.getAsesoresAsignados().forEach(usuario -> {
            idsAsesoresAsignados.add(usuario.getId());
        });

        List<Usuario> asesoresAsignados = usuarioRepository.findAllById(idsAsesoresAsignados);

        actividad.setPrioridad(prioridad);
        actividad.setAsesoresAsignados(asesoresAsignados);

        return actividadRepository.save(actividad);
    }

    public Long eliminarActividad(Long idActividad)
    {
        Actividad actividadObsoleto = actividadRepository.findById(idActividad).get();        

        actividadRepository.delete(actividadObsoleto);

        return actividadObsoleto.getId();
    }
}
