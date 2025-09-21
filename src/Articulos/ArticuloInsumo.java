package Articulos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ArticuloInsumo extends Articulo {
    private static final HashSet<ArticuloInsumo> artI = new HashSet<>();
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private Boolean esInsumo;

    // constructores personalizados
    public ArticuloInsumo(Long id, String denominacion, Double precioVenta,
                          UnidadMedida umedida, Double precioCompra,
                          Integer stockActual, Integer stockMaximo,
                          Boolean esInsumo) {
        super(id, denominacion, precioVenta, umedida, new HashSet<>());
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMaximo = stockMaximo;
        this.esInsumo = esInsumo;
        artI.add(this);
    }

    public ArticuloInsumo(Long id, String denominacion, UnidadMedida umedida,
                          Double precioCompra, Integer stockActual,
                          Integer stockMaximo) {
        super(id, denominacion, null, umedida, new HashSet<>());
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMaximo = stockMaximo;
        this.esInsumo = true;
        artI.add(this);
    }

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

    public static void mostrarInsumos(){
        if(artI.isEmpty()){
            System.out.println("**No hay insumos cargados**");
        } else {
            artI.forEach(System.out::println);
        }
        System.out.println("******************");
    }
}