package Articulos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Imagen {
    private Long id;
    private String descripcion;

    public Imagen(Long id, String descripcion, boolean withMessage) {
        this.id = id;
        this.descripcion = descripcion;
        if (withMessage) {
            System.out.println("Creaste una imagen: " + this.descripcion);
        }
    }

    @Override
    public String toString() {
        return "El id de la imagen " + this.descripcion + " es " + this.id + "\n";
    }
}