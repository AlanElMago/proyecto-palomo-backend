package dev.donjon.proyectopalomobackend.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table (name = "encuestas_servicio")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EncuestaServicio
{
    @Id
    @SequenceGenerator(
            name = "seq_encuestas_servicio",
            sequenceName = "seq_encuestas_servicio",
            allocationSize = 1,
            initialValue = 101
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_encuestas_servicio")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "encuestaServicio", fetch = FetchType.LAZY)
    private Actividad actividad;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "encuestas_servicio_crtierios",
        joinColumns = @JoinColumn(name = "id_encuesta_servicio", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_criterio", referencedColumnName = "id")
    )
    private List<Criterio> criterios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "encuestaServicio", fetch = FetchType.LAZY)
    private List<Calificacion> calificaciones = new ArrayList<>();
}
