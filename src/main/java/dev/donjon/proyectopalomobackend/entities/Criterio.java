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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Criterio
{
    @Id
    @SequenceGenerator(name = "sequencia_criterio", sequenceName = "sequencia_criterio", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_criterio")
    private Long id;

    @Column(nullable = false)
    private Short numeroOrden;

    @Column(nullable = false)
    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "criterios", fetch = FetchType.LAZY)
    private List<EncuestaServicio> encuestasServicio;

    @JsonIgnore
    @OneToMany(mappedBy = "criterio", fetch = FetchType.LAZY)
    private List<Calificacion> calificaciones;
}
