package Negocio;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString


public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Integer cp;
    private Integer piso;
    private Integer nroDpto;
    private Localidad localidad;

    @Override
    public String toString() {
      return "Domicilio { " +
              "ID: " + id +
              " // Calle: " + calle +
              " // Numero: " + numero +
              " // Codigo postal: " + cp +
              " // Piso: " + piso +
              " // Numero de departamento: " + nroDpto +
              " // Localidad: " + (localidad != null ? localidad.getNombre() : null) +  // Evitar recursión infinita
              " }";
    }
}
