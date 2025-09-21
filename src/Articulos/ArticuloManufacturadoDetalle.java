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

    public ArticuloManufacturadoDetalle(Long id, Integer cantidad, ArticuloInsumo insumo, boolean withMessage) {
        this.id = id;
        this.cantidad = cantidad;
        this.insumo = insumo;
        if (withMessage) {
            System.out.println("Creaste un detalle de manufactura con " + this.insumo.getNombre());
        }
    }

    @Override
    public String toString() {
        return "- El detalle ID " + this.id + " es de " + this.cantidad +
                this.insumo.getUnidadMedida().getAbreviatura() +
                " de " + this.insumo.getNombre() + "\n";
    }
}