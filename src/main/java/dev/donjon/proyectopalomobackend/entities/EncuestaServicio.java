package dev.donjon.proyectopalomobackend.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class EncuestaServicio
{
    @Id
    @SequenceGenerator(
            name = "sequencia_encuesta_servicio",
            sequenceName = "sequencia_encuesta_servicio",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_encuesta_servicio")
    private Long id;

    @OneToOne(mappedBy = "encuestaServicio")
    private Actividad actividad;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "encuestas_servicio_crtierios",
        joinColumns = @JoinColumn(name = "id_encuesta_servicio", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_criterio", referencedColumnName = "id")
    )
    private List<Criterio> criterios;

    @OneToMany(mappedBy = "encuestaServicio")
    private List<Calificacion> calificaciones;
}
