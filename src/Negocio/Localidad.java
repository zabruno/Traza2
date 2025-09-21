package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString


public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;

    @Override
    public String toString() {
        return "Localidad { " +
                "ID: " + id +
                " // Nombre: " + nombre +
                " // Provincia: " + (provincia != null ? provincia.getNombre() : null) + // Evitar recursion
                " }";
    }

}
