package dev.donjon.proyectopalomobackend.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "prioridades")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prioridad
{
    @Id
    @SequenceGenerator(
        name = "sequencia_prioridad",
        sequenceName = "sequencia_prioridad",
        allocationSize = 1,
        initialValue = 101
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_prioridad")
    private Long id;

    @Column(nullable = false)
    private Short nivel;
    
    @Column(nullable = false)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "prioridad", fetch = FetchType.LAZY)
    private List<Actividad> actividades = new ArrayList<>();
}
