package dev.donjon.proyectopalomobackend.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.Actividad;
import dev.donjon.proyectopalomobackend.services.ActividadService;

@RestController
@RequestMapping("/api/v1/actividad")
public class ActividadController
{
    @Autowired
    private ActividadService actividadService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Actividad>> getActividad(@PathVariable Long id)
    {
        return new ResponseEntity<Optional<Actividad>>(actividadService.getActividad(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Actividad>> getActividades()
    {
        return new ResponseEntity<List<Actividad>>(actividadService.getActividades(), HttpStatus.OK);
    }

    @GetMapping("/por-id-usuario/{id}")
    public ResponseEntity<List<Actividad>> getActividadesPorIdUsuario(@PathVariable Long idUsuario)
    {
        return new ResponseEntity<List<Actividad>>(
                actividadService.getActividadesPorIdUsuario(idUsuario), HttpStatus.OK
        );
    }
}
