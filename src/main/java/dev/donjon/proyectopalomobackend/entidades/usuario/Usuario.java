package dev.donjon.proyectopalomobackend.usuario;

import java.util.List;

import dev.donjon.proyectopalomobackend.rol.Rol;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Usuario
{
    @Id
    @SequenceGenerator(name = "sequencia_usuario", sequenceName = "sequencia_usuario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_usuario")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private List<Rol> roles;

    public Usuario (String nombre, String apellido, String email, List<Rol> roles)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("{");

        sb.append("\"id\": ").append("\"" + id + "\", ");
        sb.append("\"nombre\": ").append("\"" + nombre + "\", ");
        sb.append("\"apellido\": ").append("\"" + apellido + "\", ");
        sb.append("\"email\": ").append("\"" + email + "\", ");
        sb.append("\"roles\": {");

        for (Rol r : roles)
            sb.append(r.toString() + ", ");
        sb.replace(sb.length() - 2, sb.length() - 1, "}");

        sb.append("}");

        return sb.toString();
    }
}
