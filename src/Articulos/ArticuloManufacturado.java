package Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ArticuloManufacturado extends Articulo {
    private static final HashSet<ArticuloManufacturado> artM = new HashSet<>();
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

    public ArticuloManufacturado(Long id, String denominacion, Double precioVenta,
                                 UnidadMedida umedida, Integer tiempoEstimadoMinutos) {
        super(id, denominacion, precioVenta, umedida, new HashSet<>());
        this.descripcion = null;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.preparacion = null;
        this.detalles = new HashSet<>();
        artM.add(this);
        System.out.println("Creaste el artículo manufacturado " + this.nombre);
    }

    public void agregarDetalle(ArticuloManufacturadoDetalle artMDetalle) {
        detalles.add(artMDetalle);
        System.out.println("Agregaste " + artMDetalle.getCantidad() + " " +
                artMDetalle.getInsumo().getUnidadMedida().getAbreviatura() +
                " de " + artMDetalle.getInsumo().getNombre() +
                " a " + this.nombre);
    }

    @Override
    public String toString() {
        if (this.eliminado()) {
            return "El objeto fue eliminado\n********************\n";
        }

        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Este producto consiste en ").append(this.descripcion).append("\n")
                .append("Tarda aproximadamente ").append(this.tiempoEstimadoMinutos).append(" minutos en hacerse\n")
                .append("Se hace... ").append(this.preparacion).append("\n");

        if (detalles.isEmpty()) {
            sb.append("**No posee detalles**\n");
        } else {
            sb.append("Posee: \n");
            for (ArticuloManufacturadoDetalle d : detalles) {
                sb.append(d.toString());
            }
        }
        sb.append("----------------\n");
        return sb.toString();
    }

    public static void mostrarManufacturados(boolean completo) {
        if (artM.isEmpty()) {
            System.out.println("**No hay manufacturados cargados**");
        } else {
            if (completo) {
                artM.forEach(System.out::println);
            } else {
                System.out.println("Los manufacturados son: ");
                artM.forEach(i -> System.out.println("-" + i.getNombre()));
                System.out.println("----------------");
            }
        }
        System.out.println("******************");
    }

    // Métodos de búsqueda, actualización y eliminación quedan igual
    // (solo adaptados a usar toString en lugar de Mostrar)
}