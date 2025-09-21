package Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

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
}