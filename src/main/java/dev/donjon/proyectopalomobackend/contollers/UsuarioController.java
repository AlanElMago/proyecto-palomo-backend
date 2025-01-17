package dev.donjon.proyectopalomobackend.contollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donjon.proyectopalomobackend.entities.Usuario;
import dev.donjon.proyectopalomobackend.services.UsuarioService;

@RestController
@RequestMapping(path = "/api/v1/usuarios")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable Long id)
    {
        return new ResponseEntity<Optional<Usuario>>(usuarioService.getUsuario(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios()
    {
        return new ResponseEntity<List<Usuario>>(usuarioService.getUsuarios(), HttpStatus.OK);
    }

    @PostMapping("/crear-usuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario)
    {
        return new ResponseEntity<Usuario>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar-usuario")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario)
    {
        return new ResponseEntity<Usuario>(usuarioService.actualizarUsuario(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar-usuario/{id}")
    public ResponseEntity<Long> eliminarUsuario(@PathVariable Long id)
    {
        return new ResponseEntity<Long>(usuarioService.eliminarUsuario(id), HttpStatus.OK);
    }
}
