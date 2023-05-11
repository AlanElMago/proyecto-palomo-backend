package dev.donjon.proyectopalomobackend.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rol
{
    @Id
    @SequenceGenerator(name = "sequencia_roles", sequenceName = "sequencia_roles", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_roles")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    public Rol(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "{id: \"" + id + "\", nombre: \"" + nombre + "\"}";
    }
}
