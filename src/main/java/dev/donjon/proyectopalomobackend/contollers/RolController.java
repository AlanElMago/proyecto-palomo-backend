package dev.donjon.proyectopalomobackend.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.Rol;
import dev.donjon.proyectopalomobackend.services.RolService;

@RestController
@RequestMapping(path = "/api/v1/roles")
public class RolController
{
    @Autowired
    private RolService rolService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rol>> getRol(@PathVariable Long id)
    {
        return new ResponseEntity<Optional<Rol>>(rolService.getRol(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getRoles()
    {
        return new ResponseEntity<List<Rol>>(rolService.getRoles(), HttpStatus.OK);
    }

    @PostMapping("/crear-rol")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol)
    {
        return new ResponseEntity<Rol>(rolService.crearRol(rol), HttpStatus.CREATED);
    }

    @PostMapping("/crear-roles")
    public ResponseEntity<List<Rol>> crearRoles(@RequestBody List<Rol> roles)
    {
        return new ResponseEntity<List<Rol>>(rolService.crearRoles(roles), HttpStatus.CREATED);
    }
}
