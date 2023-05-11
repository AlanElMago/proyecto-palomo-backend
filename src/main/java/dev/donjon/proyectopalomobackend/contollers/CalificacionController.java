package dev.donjon.proyectopalomobackend.contollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.Calificacion;
import dev.donjon.proyectopalomobackend.services.CalificacionService;

@RestController
@RequestMapping("/api/v1/calificacion")
public class CalificacionController
{
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Calificacion>> getCalificacion(@PathVariable Long id)
    {
        return new ResponseEntity<Optional<Calificacion>>(calificacionService.getCalificaion(id), HttpStatus.OK);
    }
}
