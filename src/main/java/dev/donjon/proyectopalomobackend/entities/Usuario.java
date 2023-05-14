package dev.donjon.proyectopalomobackend.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario
{
    @Id
    @SequenceGenerator(
        name = "seq_usuarios",
        sequenceName = "seq_usuarios",
        allocationSize = 1,
        initialValue = 101
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private boolean activo;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id")
    )
    private List<Rol> roles = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "asesoresAsignados", fetch = FetchType.LAZY)
    private List<Actividad> actividades = new ArrayList<>();

    public Usuario (String nombre, String apellido, String email, String contrasena, List<Rol> roles)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.roles = roles;
    }
}
