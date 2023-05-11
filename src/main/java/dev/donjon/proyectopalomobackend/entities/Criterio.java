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
public class Criterio
{
    @Id
    @SequenceGenerator(name = "sequencia_criterio", sequenceName = "sequencia_criterio", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_criterio")
    private Long id;

    @Column(nullable = false)
    private Integer numeroOrden;

    @Column(nullable = false)
    private String nombre;
}
