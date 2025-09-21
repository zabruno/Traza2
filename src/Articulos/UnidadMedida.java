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

    public UnidadMedida(Long id, String abreviatura, boolean withMessage) {
        this.id = id;
        this.abreviatura = abreviatura;
        if (withMessage) {
            System.out.println("Creaste una unidad de medida: " + this.abreviatura);
        }
    }

    @Override
    public String toString() {
        return "El id de la unidad de medida " + this.abreviatura + " es " + this.id + "\n";
    }
}