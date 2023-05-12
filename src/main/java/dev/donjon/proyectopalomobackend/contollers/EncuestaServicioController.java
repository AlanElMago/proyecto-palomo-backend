package dev.donjon.proyectopalomobackend.contollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.EncuestaServicio;
import dev.donjon.proyectopalomobackend.services.EncuestaServicioService;

@RestController
@RequestMapping("/api/v1/encuesta-servicio")
public class EncuestaServicioController
{
    @Autowired
    private EncuestaServicioService encuestaServicioService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EncuestaServicio>> getEncuestaServicio(@PathVariable Long id)
    {
        return new ResponseEntity<Optional<EncuestaServicio>>(
                encuestaServicioService.getEncuestaServicio(id), HttpStatus.OK
        );
    }
}
