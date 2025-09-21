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
@ToString(exclude= "sucursales") //evita recursion


public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;

    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @Override
    public String toString(){
        return "Empresa {"
                + "ID: " + id
                + " // Nombre: "+ nombre
                + " // Razon social: "+ razonSocial
                + " // CUIT: " + cuit
                + " }";
    }
}
