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

import dev.donjon.proyectopalomobackend.entities.Prioridad;
import dev.donjon.proyectopalomobackend.services.PrioridadService;

@RestController
@RequestMapping(path = "/api/v1/prioridades")
public class PrioridadController
{
    @Autowired
    private PrioridadService prioridadService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Prioridad>> getPrioridad(@PathVariable Long id)
    {
        return new ResponseEntity<Optional<Prioridad>>(prioridadService.getPrioridad(id), HttpStatus.OK);
    }

    @GetMapping("/por-nivel/{nivel}")
    public ResponseEntity<Optional<Prioridad>> getPrioridadPorNivel(@PathVariable Integer nivel)
    {
        return new ResponseEntity<Optional<Prioridad>>(prioridadService.getPrioridadPorNivel(nivel), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Prioridad>> getPrioridades()
    {
        return new ResponseEntity<List<Prioridad>>(prioridadService.getPrioridades(), HttpStatus.OK);
    }
}
