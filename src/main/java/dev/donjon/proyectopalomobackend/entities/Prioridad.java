package dev.donjon.proyectopalomobackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Prioridad
{
    @Id
    @SequenceGenerator(name = "sequencia_prioridad", sequenceName = "sequencia_prioridad", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_prioridad")
    private Long id;

    @Column(nullable = false)
    private Integer nivel;
    
    @Column(nullable = false)
    private String nombre;
}
