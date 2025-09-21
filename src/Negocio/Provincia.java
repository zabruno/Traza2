package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString


public class Provincia {
    private Long id;
    private String nombre;

    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
    private Pais pais;

    @Override
    public String toString() {
        return "Provincia { " +
                "ID: " + id +
                " // Nombre: " + nombre + '\'' +
                " // Pais: " + (pais != null ? pais.getNombre() : null) + // Evitar recursión
                " }";
    }

}
