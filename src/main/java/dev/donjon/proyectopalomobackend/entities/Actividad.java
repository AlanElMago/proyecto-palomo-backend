package dev.donjon.proyectopalomobackend.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "actividades")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actividad
{
    @Id 
    @SequenceGenerator(
        name = "seq_actividades",
        sequenceName = "seq_actividades",
        allocationSize = 1,
        initialValue = 101
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_actividades")
    private Long id;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String nombreSolicitante;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prioridad")
    private Prioridad prioridad;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_encuesta_servicio")
    private EncuestaServicio encuestaServicio;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "actividades_usuarios",
        joinColumns = @JoinColumn(name = "id_actividad", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    )
    private List<Usuario> asesoresAsignados = new ArrayList<>();

    public Actividad(
            String asunto,
            String nombreSolicitante,
            String descripcion,
            Prioridad prioridad,
            List<Usuario> asesoresAsignados
    )
    {
        this.asunto = asunto;
        this.nombreSolicitante = nombreSolicitante;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.asesoresAsignados = asesoresAsignados;
    }
}
