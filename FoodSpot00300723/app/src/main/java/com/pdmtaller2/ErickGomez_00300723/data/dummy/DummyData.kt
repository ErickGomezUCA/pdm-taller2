package com.pdmtaller2.ErickGomez_00300723.data.dummy

import com.pdmtaller2.ErickGomez_00300723.data.model.Dish
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant

val restaurants: List<Restaurant> = listOf(
    Restaurant(
        id = 1,
        name = "El Rincón Mexicano",
        description = "Sabores auténticos de México en cada bocado.",
        imageUrl = "https://popmenucloud.com/cdn-cgi/image/width%3D1200%2Cheight%3D1200%2Cfit%3Dscale-down%2Cformat%3Dauto%2Cquality%3D60/xrpblwcd/85ba676e-8969-4793-ba64-46c7724547be.jpg",
        categories = listOf("Comida Mexicana", "Comida Rápida", "Bebidas"),
        menu = listOf(
            Dish(1, "Tacos", "Tacos sabrosos.", "https://images.pexels.com/photos/2092507/pexels-photo-2092507.jpeg"),
            Dish(2, "Enchiladas Verdes", "Tortillas rellenas con salsa verde.", "https://images.pexels.com/photos/2092507/pexels-photo-2092507.jpeg"),
            Dish(3, "Pozole", "Sopa tradicional mexicana con maíz y carne.", "https://example.com/pozole.jpg"),
            Dish(4, "Chiles Rellenos", "Chiles poblanos rellenos de queso.", "https://example.com/chiles_rellenos.jpg"),
            Dish(5, "Agua de Jamaica", "Refrescante bebida de flor de jamaica.", "https://example.com/agua_jamaica.jpg")
        )
    ),
    Restaurant(
        id = 2,
        name = "La Pizza Italiana",
        description = "Pizzas artesanales con ingredientes frescos.",
        imageUrl = "https://example.com/la_pizza_italiana.jpg",
        categories = listOf("Comida Italiana", "Postres y Dulces", "Bebidas"),
        menu = listOf(
            Dish(6, "Pizza Napolitana", "Pizza clásica con tomate y albahaca.", "https://example.com/pizza_napolitana.jpg"),
            Dish(7, "Lasaña", "Capas de pasta con carne y queso.", "https://example.com/lasagna.jpg"),
            Dish(8, "Tiramisú", "Postre italiano con café y mascarpone.", "https://example.com/tiramisu.jpg"),
            Dish(9, "Gelato de Pistacho", "Helado cremoso de pistacho.", "https://example.com/gelato_pistacho.jpg"),
            Dish(10, "Capuchino", "Café espumoso al estilo italiano.", "https://example.com/capuchino.jpg")
        )
    ),
    Restaurant(
        id = 3,
        name = "Sabor Asiático",
        description = "Platos asiáticos llenos de tradición y frescura.",
        imageUrl = "https://example.com/sabor_asiatico.jpg",
        categories = listOf("Comida Asiática", "Comida Saludable", "Bebidas"),
        menu = listOf(
            Dish(11, "Sushi de Salmón", "Rollos de sushi con salmón fresco.", "https://example.com/sushi_salmon.jpg"),
            Dish(12, "Ramen", "Sopa japonesa con fideos y cerdo.", "https://example.com/ramen.jpg"),
            Dish(13, "Arroz Frito", "Arroz salteado con vegetales y huevo.", "https://example.com/arroz_frito.jpg"),
            Dish(14, "Pollo Teriyaki", "Pollo glaseado con salsa teriyaki.", "https://example.com/pollo_teriyaki.jpg"),
            Dish(15, "Té Verde", "Bebida tradicional japonesa.", "https://example.com/te_verde.jpg")
        )
    ),
    Restaurant(
        id = 4,
        name = "Delicias Saludables",
        description = "Comida nutritiva y deliciosa para todos.",
        imageUrl = "https://example.com/delicias_saludables.jpg",
        categories = listOf("Comida Saludable", "Postres y Dulces", "Bebidas"),
        menu = listOf(
            Dish(16, "Ensalada César", "Ensalada fresca con aderezo césar.", "https://example.com/ensalada_cesar.jpg"),
            Dish(17, "Wrap de Pollo", "Tortilla rellena de pollo y vegetales.", "https://example.com/wrap_pollo.jpg"),
            Dish(18, "Smoothie de Fresa", "Batido de frutas frescas.", "https://example.com/smoothie_fresa.jpg"),
            Dish(19, "Barra de Granola", "Barra energética con frutos secos.", "https://example.com/barra_granola.jpg"),
            Dish(20, "Agua de Coco", "Bebida natural y refrescante.", "https://example.com/agua_coco.jpg")
        )
    ),
    Restaurant(
        id = 5,
        name = "Dulces Momentos",
        description = "Postres que endulzan tu día.",
        imageUrl = "https://example.com/dulces_momentos.jpg",
        categories = listOf("Postres y Dulces", "Bebidas"),
        menu = listOf(
            Dish(21, "Pastel de Chocolate", "Pastel esponjoso con chocolate.", "https://example.com/pastel_chocolate.jpg"),
            Dish(22, "Flan de Caramelo", "Postre cremoso con caramelo.", "https://example.com/flan_caramelo.jpg"),
            Dish(23, "Helado de Vainilla", "Helado clásico de vainilla.", "https://example.com/helado_vainilla.jpg"),
            Dish(24, "Brownies", "Deliciosos brownies de chocolate.", "https://example.com/brownies.jpg"),
            Dish(25, "Batido de Mango", "Bebida dulce y refrescante.", "https://example.com/batido_mango.jpg")
        )
    ),
    Restaurant(
        id = 6,
        name = "Burgers & More",
        description = "Hamburguesas y más para los amantes de la comida rápida.",
        imageUrl = "https://example.com/burgers_and_more.jpg",
        categories = listOf("Comida Rápida", "Bebidas"),
        menu = listOf(
            Dish(26, "Hamburguesa Clásica", "Hamburguesa con queso y lechuga.", "https://example.com/hamburguesa_clasica.jpg"),
            Dish(27, "Papas Fritas", "Papas doradas y crujientes.", "https://example.com/papas_fritas.jpg"),
            Dish(28, "Hot Dog", "Salchicha en pan con aderezos.", "https://example.com/hot_dog.jpg"),
            Dish(29, "Aros de Cebolla", "Cebolla empanizada y frita.", "https://example.com/aros_cebolla.jpg"),
            Dish(30, "Refresco", "Bebida gaseosa de tu elección.", "https://example.com/refresco.jpg")
        )
    ),
    Restaurant(
        id = 7,
        name = "La Parrilla Argentina",
        description = "Cortes de carne al estilo argentino.",
        imageUrl = "https://example.com/la_parrilla_argentina.jpg",
        categories = listOf("Carnes", "Bebidas"),
        menu = listOf(
            Dish(31, "Asado", "Carne a la parrilla con chimichurri.", "https://example.com/asado.jpg"),
            Dish(32, "Empanadas", "Empanadas rellenas de carne.", "https://example.com/empanadas.jpg"),
            Dish(33, "Chorizo", "Chorizo argentino a la parrilla.", "https://example.com/chorizo.jpg"),
            Dish(34, "Provoleta", "Queso a la parrilla con especias.", "https://example.com/provoleta.jpg"),
            Dish(35, "Vino Tinto", "Acompañamiento perfecto para la carne.", "https://example.com/vino_tinto.jpg")
        )
    ),
    Restaurant(
        id = 8,
        name = "Sabores del Caribe",
        description = "Platos tropicales llenos de sabor.",
        imageUrl = "https://example.com/sabores_caribe.jpg",
        categories = listOf("Comida Saludable", "Bebidas"),
        menu = listOf(
            Dish(36, "Ceviche", "Pescado marinado con limón y especias.", "https://example.com/ceviche.jpg"),
            Dish(37, "Tostones", "Plátanos fritos crujientes.", "https://example.com/tostones.jpg"),
            Dish(38, "Arroz con Coco", "Arroz dulce con leche de coco.", "https://example.com/arroz_coco.jpg"),
            Dish(39, "Batido de Piña", "Bebida tropical refrescante.", "https://example.com/batido_pina.jpg"),
            Dish(40, "Coctel de Camarones", "Camarones en salsa de tomate.", "https://example.com/coctel_camarones.jpg")
        )
    ),
    Restaurant(
        id = 9,
        name = "Veggie Life",
        description = "Comida vegetariana para un estilo de vida saludable.",
        imageUrl = "https://example.com/veggie_life.jpg",
        categories = listOf("Comida Saludable", "Vegetariano", "Bebidas"),
        menu = listOf(
            Dish(41, "Hamburguesa Vegana", "Hamburguesa hecha con vegetales.", "https://example.com/hamburguesa_vegana.jpg"),
            Dish(42, "Ensalada de Kale", "Ensalada fresca con kale y aderezo.", "https://example.com/ensalada_kale.jpg"),
            Dish(43, "Sopa de Lentejas", "Sopa nutritiva de lentejas.", "https://example.com/sopa_lentejas.jpg"),
            Dish(44, "Smoothie Verde", "Batido de espinaca y frutas.", "https://example.com/smoothie_verde.jpg"),
            Dish(45, "Té de Hierbas", "Infusión relajante de hierbas.", "https://example.com/te_hierbas.jpg")
        )
    ),
    Restaurant(
        id = 10,
        name = "Café Colonial",
        description = "Café y postres en un ambiente acogedor.",
        imageUrl = "https://example.com/cafe_colonial.jpg",
        categories = listOf("Postres y Dulces", "Bebidas"),
        menu = listOf(
            Dish(46, "Café Latte", "Café con leche espumosa.", "https://example.com/cafe_latte.jpg"),
            Dish(47, "Croissant", "Pan francés suave y mantecoso.", "https://example.com/croissant.jpg"),
            Dish(48, "Tarta de Manzana", "Postre clásico con manzanas.", "https://example.com/tarta_manzana.jpg"),
            Dish(49, "Muffin de Arándanos", "Muffin dulce con arándanos.", "https://example.com/muffin_arandanos.jpg"),
            Dish(50, "Chocolate Caliente", "Bebida caliente y reconfortante.", "https://example.com/chocolate_caliente.jpg")
        )
    )
)