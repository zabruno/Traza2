package Articulos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UnidadMedida {
    private Long id;
    private String abreviatura;

    @Override
    public String toString() {
        return "El id de la unidad de medida " + this.abreviatura + " es " + this.id + "\n";
    }
}