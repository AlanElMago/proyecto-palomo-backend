package dev.donjon.proyectopalomobackend.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @SequenceGenerator(name = "sequencia_rol", sequenceName = "sequencia_rol", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_rol")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
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
