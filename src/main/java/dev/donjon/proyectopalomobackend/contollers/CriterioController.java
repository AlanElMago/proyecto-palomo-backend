package dev.donjon.proyectopalomobackend.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.Criterio;
import dev.donjon.proyectopalomobackend.services.CriterioService;

@RestController
@RequestMapping("/api/v1/critero")
public class CriterioController
{
    @Autowired
    private CriterioService criterioService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Criterio>> getCriterio(Long id)
    {
        return new ResponseEntity<Optional<Criterio>>(criterioService.getCriterio(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Criterio>> getCriterios()
    {
        return new ResponseEntity<List<Criterio>>(criterioService.getCriterios(), HttpStatus.OK);
    }
}
