package Entidades;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString(exclude="empresa") //Evita recursion

public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;

    private Empresa empresa;

    private Domicilio domicilio;

public String toString(){
    return "Sucursal { "+
            "ID: " + id +
            " // Nombre: " + nombre + '\'' +
            " // Horario de apertura: " + horarioApertura +
            " // Horario de cierre: " + horarioCierre +
            " // Es casa matriz: " + es_Casa_Matriz +
            " // Domicilio: " + domicilio +
            " }";
    }
}
