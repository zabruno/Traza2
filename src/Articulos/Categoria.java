package Articulos;

import lombok.*;
import java.util.HashSet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria {
    private Long id;
    private String nombre;
    @Builder.Default
    private HashSet<Articulo> articulos = new HashSet<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.nombre + " (ID: " + this.id + ") con artículos:\n");
        if (articulos.isEmpty()) {
            sb.append("**No hay artículos en esta categoría**\n");
        } else {
            articulos.forEach(a -> sb.append("- ").append(a.getNombre()).append("\n"));
        }
        sb.append("----------------\n");
        return sb.toString();
    }
}