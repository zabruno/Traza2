package Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ArticuloInsumo extends Articulo {
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esInsumo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Tiene un costo de $").append(this.precioCompra)
                .append(" por ").append(this.getUnidadMedida().getAbreviatura()).append("\n");
        sb.append("La cantidad disponible es ").append(this.stockActual)
                .append("/").append(this.stockMaximo).append("\n");
        sb.append("----------------\n");
        return sb.toString();
    }
}