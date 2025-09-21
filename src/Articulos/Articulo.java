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

public abstract class Articulo {
    protected Long id;
    protected String nombre;
    protected Double precioVenta;
    private UnidadMedida unidadMedida;
    @Builder.Default
    private HashSet<Imagen> imagenes = new HashSet<>();

    public void agregarImagen(Imagen img){
        this.imagenes.add(img);
    }

    public void limpiarImagenes() {
        this.imagenes.clear();
    }

    public boolean eliminado(){
        return this.id == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.eliminado()) {
            sb.append("El objeto fue eliminado\n");
            sb.append("********************\n");
            return sb.toString();
        }

        sb.append("El artículo ").append(this.nombre)
                .append(" de ID: ").append(this.id).append("\n");

        if (this.precioVenta != null) {
            sb.append("Tiene un precio de venta $").append(this.precioVenta)
                    .append(" y su unidad de medida es ").append(this.unidadMedida.getAbreviatura()).append("\n");
        } else {
            sb.append("Es un insumo de elaboración y su unidad de medida es ").append(this.unidadMedida).append("\n");
        }

        if (imagenes.isEmpty()) {
            sb.append("No posee imágenes\n");
        } else {
            sb.append("Sus imágenes son: \n");
            for (Imagen i : this.imagenes) {
                sb.append(" - ").append(i.getDescripcion()).append("\n");
            }
        }

        return sb.toString();
    }
}