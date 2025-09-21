package Negocio;

import Articulos.Articulo;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;

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
    @Builder.Default
    private HashSet<Articulo> articulos = new HashSet<>();

    @Override
    public String toString() {
        String estadoArticulos = (articulos == null || articulos.isEmpty())
                ? "Sin artículos"
                : "Con artículos (" + articulos.size() + ")";

        return "Sucursal {\n" +
                "   ID: " + id + "\n" +
                "   Nombre: " + nombre + "\n" +
                "   Horario de apertura: " + horarioApertura + "\n" +
                "   Horario de cierre: " + horarioCierre + "\n" +
                "   Es casa matriz: " + es_Casa_Matriz + "\n" +
                "   Domicilio: " + domicilio.getCalle() +"; "+domicilio.getNumero() + "; " + domicilio.getLocalidad() + "\n" +
                "   Artículos: " + estadoArticulos + "\n" +
                "}\n";
    }

    public void agregarArticulo (Articulo articulo) {
    this.articulos.add(articulo);
    articulo.getSucursales().add(this);
    }

    //deberia sobreescribir metodos equal y hashcode
}
