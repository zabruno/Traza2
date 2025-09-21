package Articulos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;
    private ArticuloInsumo insumo;

    @Override
    public String toString() {
        return "- El detalle ID " + this.id + " es de " + this.cantidad +
                this.insumo.getUnidadMedida().getAbreviatura() +
                " de " + this.insumo.getNombre() + "\n";
    }
}