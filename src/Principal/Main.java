package Principal;

    import Articulos.*;
    import Negocio.*;
    import Repositorio.*;

    import java.awt.*;
    import java.time.LocalTime;
    import java.util.*;
    import java.util.List;


//Se reutilizaron las clases de un proyecto de Paradigmas de Programacion
//Se adapto el proyecto para que use lombok y el repositorio de Traza1
//Se agregaron las clases de traza 1

public class Main {
    public static void main(String[] args) {
        //<editor-fold desc="Creacion de Negocios">

        InMemoryRepository<Empresa> EmpresaRepo = new InMemoryRepository<>();
        System.out.println(" -----------Creamos el repositorio----------");

        Pais arg = Pais.builder()
                .nombre("Argentina")
                .build();
        System.out.println(" -----------Creamos un pais----------");

        Provincia mza = Provincia.builder()
                .id(1L)
                .nombre("Mendoza")
                .pais(arg)
                .build();
        Provincia cba = Provincia.builder()
                .id(2L)
                .nombre("Cordoba")
                .pais(arg)
                .build();
        System.out.println(" -----------Creamos provincias----------");

        Localidad LH = Localidad.builder()
                .id(1L)
                .nombre("Las Heras")
                .provincia(mza)
                .build();
        Localidad CP = Localidad.builder()
                .id(2L)
                .nombre("Carlos Paz")
                .provincia(cba)
                .build();
        Localidad cap = Localidad.builder()
                .id(3L)
                .nombre("Capital")
                .provincia(cba)
                .build();
        Localidad gy = Localidad.builder()
                .id(4L)
                .nombre("Guaymallen")
                .provincia(mza)
                .build();
        System.out.println(" -----------Creamos localidades----------");

        Domicilio dom1 = Domicilio.builder()
                .id(1L)
                .calle("Antartida Argentina")
                .numero(1000)
                .cp(5539)
                .piso(1)
                .nroDpto(1)
                .localidad(LH)
                .build();
        Domicilio dom2 = Domicilio.builder()
                .id(2L)
                .calle("San Martin")
                .numero(600)
                .cp(8504)
                .piso(1)
                .nroDpto(1)
                .localidad(CP)
                .build();
        Domicilio dom3 = Domicilio.builder()
                .id(3L)
                .calle("Belgrano")
                .numero(200)
                .cp(8509)
                .piso(1)
                .nroDpto(1)
                .localidad(cap)
                .build();
        Domicilio dom4 = Domicilio.builder()
                .id(4L)
                .calle("Cabral")
                .numero(850)
                .cp(5509)
                .piso(1)
                .nroDpto(1)
                .localidad(gy)
                .build();
        System.out.println(" -----------Creamos domicilios----------");

        Sucursal suc1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 1 LH")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(10, 0))
                .es_Casa_Matriz(true)
                .domicilio(dom1)
                .build();
        Sucursal suc2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal 2 GY")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(10, 30))
                .es_Casa_Matriz(false)
                .domicilio(dom4)
                .build();
        Sucursal suc3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal 3 CP")
                .horarioApertura(LocalTime.of(9, 30))
                .horarioCierre(LocalTime.of(15, 30))
                .es_Casa_Matriz(true)
                .domicilio(dom2)
                .build();
        Sucursal suc4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal 4 CAP")
                .horarioApertura(LocalTime.of(6, 0))
                .horarioCierre(LocalTime.of(10, 0))
                .es_Casa_Matriz(false)
                .domicilio(dom3)
                .build();
        System.out.println(" -----------Creamos sucursales----------");

        Empresa empresa1 = Empresa.builder()
                .nombre("Empresa 1")
                .razonSocial("CARGAS SA")
                .cuit((int) 30709969583L)
                .sucursales(new HashSet<>(Set.of(suc1, suc2)))
                .build();
        Empresa empresa2 = Empresa.builder()
                .nombre("Empresa 2")
                .razonSocial("INCAT SRL")
                .cuit((int) 30525418835L)
                .sucursales(new HashSet<>(Set.of(suc3, suc4)))
                .build();
        System.out.println(" -----------Creamos empresas----------");

        suc1.setEmpresa(empresa1);
        suc2.setEmpresa(empresa1);
        suc3.setEmpresa(empresa2);
        suc4.setEmpresa(empresa2);
        System.out.println(" -----------Asignamos la empresa a las sucursales----------");

        EmpresaRepo.save(empresa1);
        EmpresaRepo.save(empresa2);
        System.out.println(" -----------Guardamos las empresas----------");

        List<Empresa> listaEmpresas=EmpresaRepo.findAll();
        listaEmpresas.forEach(empresa->System.out.println(empresa));
        System.out.println(" -----------a) Mostramos las empresas----------");

        Optional<Empresa> encontrarEmpresa = EmpresaRepo.findById(2L);
        encontrarEmpresa.ifPresent(e->System.out.println("Empresa de ID 2: "+e));
        System.out.println(" -----------b) Encontramos empresa por ID----------");

        List<Empresa> nombreEmpresa = EmpresaRepo.genericFindByField("nombre","Empresa 1");
        System.out.println("Empresas con nombre Empresa 1: ");
        nombreEmpresa.forEach(empresa->System.out.println(empresa));
        System.out.println(" -----------c) Buscamos empresa por nombre----------");

        Empresa actualizacionEmpresa = Empresa.builder()
                .id(1L)
                .nombre("Empresa 3")
                .razonSocial("GASVER SA")
                .cuit((int) 20431194687L)
                .sucursales(empresa1.getSucursales())
                .build();
        EmpresaRepo.genericUpdate(1L, actualizacionEmpresa);
        Optional<Empresa> empresaModificada = EmpresaRepo.findById(1L);
        empresaModificada.ifPresent(empresa->System.out.println("Se actualizó a "+empresa));
        System.out.println(" -----------d) Actualizamos datos de una empresa por ID----------");

        EmpresaRepo.genericDelete(1L);
        Optional<Empresa> empresaBorrada = EmpresaRepo.findById(1L);
        if(empresaBorrada.isEmpty()) {
            System.out.println("La empresa fue eliminada");
        }
        System.out.println("Las empresas restantes son: ");
        List<Empresa> empresasRestantes = EmpresaRepo.findAll();
        empresasRestantes.forEach(empresa->System.out.println(empresa));
        System.out.println(" -----------e) Eliminamos empresa con ID----------");
        //</editor-fold>

        //<editor-fold desc="Creacion de Articulos">
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
        ArticuloInsumo  cocaCola = insumoRepo.save(
                ArticuloInsumo.builder()
                        .nombre("Coca Cola")
                        .unidadMedida(unidades)
                        .precioCompra(15D)
                        .stockActual(100)
                        .stockMaximo(250)
                        .esInsumo(true)
                        .build()
        );
        List<ArticuloInsumo> todosLosInsumos = insumoRepo.findAll();
        for (ArticuloInsumo insumo : todosLosInsumos) {
            insumosCat.getArticulos().add(insumo); // usando el método que definimos
        }

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
        pizzas.getArticulos().add(pizzaHawaiana);

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
        lomos.getArticulos().add(lomoCompleto);

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
        //</editor-fold>

        //<editor-fold desc="Enlazar articulos y negocios">
        insumoRepo.findAll().forEach(suc1::agregarArticulo);
        System.out.println(suc1.toString());
        System.out.println(suc2.toString());
        System.out.println(sal.toString());
        //Entiendo que deberia refinar cosas como que por ej el stock sea por sucursal
        //</editor-fold>
    }
}