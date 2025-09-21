package Principal;

    import Articulos.*;
    import Repositorio.*;
    import java.awt.*;
    import java.util.Arrays;
    import java.util.HashSet;


//Se reutilizaron las clases de un proyecto de Paradigmas de Programacion
//Se adapto el proyecto para que use lombok y el repositorio de Traza1


public class Main {
    public static void main(String[] args) {
        // Repositorios
        InMemoryRepository<Categoria> categoriaRepo = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> insumoRepo = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturadoDetalle> detalleRepo = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> manufacturadoRepo = new InMemoryRepository<>();

        // ==================== Categorías ====================
        Categoria pizzas = categoriaRepo.save(
                Categoria.builder().nombre("Pizzas").build()
        );
        Categoria sandwich = categoriaRepo.save(
                Categoria.builder().nombre("Sandwich").build()
        );
        Categoria lomos = categoriaRepo.save(
                Categoria.builder().nombre("Lomos").build()
        );
        Categoria insumosCat = categoriaRepo.save(
                Categoria.builder().nombre("Insumos").build()
        );

        // ==================== Unidades ====================
        UnidadMedida kilogramos = unidadRepo.save(
                UnidadMedida.builder().abreviatura("kg").build()
        );
        UnidadMedida litros = unidadRepo.save(
                UnidadMedida.builder().abreviatura("L").build()
        );
        UnidadMedida gramos = unidadRepo.save(
                UnidadMedida.builder().abreviatura("g").build()
        );
        UnidadMedida unidades = unidadRepo.save(
                UnidadMedida.builder().abreviatura("u").build()
        );

        // ==================== Insumos ====================
        ArticuloInsumo sal = insumoRepo.save(
                ArticuloInsumo.builder()
                        .nombre("Sal")
                        .unidadMedida(gramos)
                        .precioCompra(65D)
                        .stockActual(25)
                        .stockMaximo(100)
                        .build()
        );
        ArticuloInsumo aceite = insumoRepo.save(
                ArticuloInsumo.builder()
                        .nombre("Aceite")
                        .unidadMedida(litros)
                        .precioCompra(100D)
                        .stockActual(65)
                        .stockMaximo(100)
                        .build()
        );
        ArticuloInsumo carne = insumoRepo.save(
                ArticuloInsumo.builder()
                        .nombre("Carne")
                        .unidadMedida(kilogramos)
                        .precioCompra(60D)
                        .stockActual(75)
                        .stockMaximo(100)
                        .build()
        );
        ArticuloInsumo harina = insumoRepo.save(
                ArticuloInsumo.builder()
                        .nombre("Harina")
                        .unidadMedida(kilogramos)
                        .precioCompra(15D)
                        .stockActual(60)
                        .stockMaximo(100)
                        .build()
        );
        ArticuloInsumo cocaCola = insumoRepo.save(
                ArticuloInsumo.builder()
                        .nombre("Coca Cola")
                        .unidadMedida(unidades)
                        .precioCompra(15D)
                        .stockActual(100)
                        .stockMaximo(250)
                        .esInsumo(true)
                        .build()
        );

        // ==================== Imágenes ====================
        Imagen hPizzaV1 = imagenRepo.save(Imagen.builder().descripcion("Pizza Hawaiana 1").build());
        Imagen hPizzaV2 = imagenRepo.save(Imagen.builder().descripcion("Pizza Hawaiana 2").build());
        Imagen hPizzaV3 = imagenRepo.save(Imagen.builder().descripcion("Pizza Hawaiana 3").build());
        Imagen lCompV1 = imagenRepo.save(Imagen.builder().descripcion("Lomo completo 1").build());
        Imagen lCompV2 = imagenRepo.save(Imagen.builder().descripcion("Lomo completo 2").build());
        Imagen lCompV3 = imagenRepo.save(Imagen.builder().descripcion("Lomo completo 3").build());

        // ==================== Detalles ====================
        ArticuloManufacturadoDetalle hPizzaV1Detalle = detalleRepo.save(
                ArticuloManufacturadoDetalle.builder()
                        .cantidad(1)
                        .insumo(sal)
                        .build()
        );
        ArticuloManufacturadoDetalle hPizzaV2Detalle = detalleRepo.save(
                ArticuloManufacturadoDetalle.builder()
                        .cantidad(2)
                        .insumo(harina)
                        .build()
        );
        ArticuloManufacturadoDetalle hPizzaV3Detalle = detalleRepo.save(
                ArticuloManufacturadoDetalle.builder()
                        .cantidad(1)
                        .insumo(aceite)
                        .build()
        );
        ArticuloManufacturadoDetalle lCompV1Detalle = detalleRepo.save(
                ArticuloManufacturadoDetalle.builder()
                        .cantidad(1)
                        .insumo(sal)
                        .build()
        );
        ArticuloManufacturadoDetalle lCompV2Detalle = detalleRepo.save(
                ArticuloManufacturadoDetalle.builder()
                        .cantidad(1)
                        .insumo(aceite)
                        .build()
        );
        ArticuloManufacturadoDetalle lCompV3Detalle = detalleRepo.save(
                ArticuloManufacturadoDetalle.builder()
                        .cantidad(1)
                        .insumo(carne)
                        .build()
        );

        // ==================== Manufacturados ====================
        ArticuloManufacturado pizzaHawaiana = manufacturadoRepo.save(
                ArticuloManufacturado.builder()
                        .nombre("Pizza Hawaiana")
                        .unidadMedida(unidades)
                        .precioVenta(80D)
                        .tiempoEstimadoMinutos(20)
                        .imagenes(new HashSet<>(Arrays.asList(hPizzaV1, hPizzaV2, hPizzaV3)))
                        .detalles(new HashSet<>(Arrays.asList(hPizzaV1Detalle, hPizzaV2Detalle, hPizzaV3Detalle)))
                        .build()
        );

        ArticuloManufacturado lomoCompleto = manufacturadoRepo.save(
                ArticuloManufacturado.builder()
                        .nombre("Lomo Completo")
                        .unidadMedida(unidades)
                        .precioVenta(12D)
                        .tiempoEstimadoMinutos(25)
                        .imagenes(new HashSet<>(Arrays.asList(lCompV1, lCompV2, lCompV3)))
                        .detalles(new HashSet<>(Arrays.asList(lCompV1Detalle, lCompV2Detalle, lCompV3Detalle)))
                        .build()
        );

        // ==================== Mostrar ====================
        System.out.println("=== Categorías ===");
        categoriaRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== Insumos ===");
        insumoRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== Manufacturados ===");
        manufacturadoRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== Buscar manufacturado por ID ===");
        manufacturadoRepo.findById(pizzaHawaiana.getId()).ifPresent(System.out::println);

        System.out.println("\n=== Update Pizza Hawaiana ===");
        pizzaHawaiana.setNombre("Pizza Hawaiana Especial");
        manufacturadoRepo.genericUpdate(pizzaHawaiana.getId(), pizzaHawaiana);
        manufacturadoRepo.findById(pizzaHawaiana.getId()).ifPresent(System.out::println);

        System.out.println("\n=== Eliminar Lomo Completo ===");
        manufacturadoRepo.genericDelete(lomoCompleto.getId());
        manufacturadoRepo.findAll().forEach(System.out::println);
    }
}