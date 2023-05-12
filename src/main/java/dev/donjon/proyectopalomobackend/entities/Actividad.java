package dev.donjon.proyectopalomobackend.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actividad
{
    @Id 
    @SequenceGenerator(name = "sequencia_actividad", sequenceName = "sequencia_actividad", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_actividad")
    private Long id;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String nombreSolicitate;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prioridad")
    private Prioridad prioridad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_encuesta_servicio")
    private EncuestaServicio encuestaServicio;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "actividades_usuarios",
        joinColumns = @JoinColumn(name = "id_actividad", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    )
    private List<Usuario> asesoresAsignados;
}
