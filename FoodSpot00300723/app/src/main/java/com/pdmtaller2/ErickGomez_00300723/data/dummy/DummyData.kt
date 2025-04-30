package com.pdmtaller2.ErickGomez_00300723.data.dummy

import com.pdmtaller2.ErickGomez_00300723.data.model.Dish
import com.pdmtaller2.ErickGomez_00300723.data.model.Restaurant

val restaurants: List<Restaurant> = listOf(
    Restaurant(
        id = 1,
        name = "El Rincón Mexicano",
        description = "Sabores auténticos de México en cada bocado.",
        imageUrl = "https://popmenucloud.com/cdn-cgi/image/width%3D1200%2Cheight%3D1200%2Cfit%3Dscale-down%2Cformat%3Dauto%2Cquality%3D60/xrpblwcd/85ba676e-8969-4793-ba64-46c7724547be.jpg",
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(1, "Tacos", "Tortillas suaves rellenas con una deliciosa mezcla de carne sazonada.", "https://images.pexels.com/photos/2092507/pexels-photo-2092507.jpeg"),
            Dish(2, "Enchiladas Verdes", "Tortillas rellenas con salsa verde.", "https://editorialtelevisa.brightspotcdn.com/dims4/default/4a5dbdb/2147483647/strip/true/crop/996x560+2+0/resize/1440x810!/quality/90/?url=https%3A%2F%2Fk2-prod-editorial-televisa.s3.us-east-1.amazonaws.com%2Fbrightspot%2Fwp-content%2Fuploads%2F2019%2F05%2Fenchiladas-verdes.png"),
            Dish(3, "Pozole", "Sopa tradicional mexicana con maíz y carne.", "https://sabrosano.com/wp-content/uploads/2020/05/Pozole_06.jpg"),
            Dish(4, "Chiles Rellenos", "Chiles poblanos rellenos de queso.", "https://s3.amazonaws.com/static.realcaliforniamilk.com/media/recipes_2/chile-rellenos.jpg"),
            Dish(5, "Agua de Jamaica", "Refrescante bebida de flor de jamaica.", "https://nomadasgourmet.com/wp-content/uploads/2023/12/como-hacer-agua-de-jamaica-jarra-vasos-2-5.jpg")
        )
    ),
    Restaurant(
        id = 2,
        name = "La Pizza Italiana",
        description = "Pizzas artesanales con ingredientes frescos.",
        imageUrl = "https://imagenes.20minutos.es/files/image_990_556/uploads/imagenes/2024/12/05/trattoria-pulcinella-madrid.jpeg",
        categories = listOf("Comida Italiana", "Bebidas"),
        menu = listOf(
            Dish(6, "Pizza Napolitana", "Pizza clásica con tomate y albahaca.", "https://imag.bonviveur.com/pizza-napolitana-casera.jpg"),
            Dish(7, "Lasaña", "Capas de pasta con carne y queso.", "https://newmansown.com/wp-content/uploads/2022/03/Homemade-lasagna-1200x675.png"),
            Dish(8, "Tiramisú", "Postre italiano con café y mascarpone.", "https://www.recetasnestle.com.ec/sites/default/files/srh_recipes/7f45d6f8807ebc775928651a3398dce9.png"),
            Dish(9, "Gelato de Pistacho", "Helado cremoso de pistacho.", "https://www.hogarmania.com/archivos/202308/helado-pistacho-1280x720x80xX-1.jpg"),
            Dish(10, "Capuchino", "Café espumoso al estilo italiano.", "https://www.cocinatis.com/archivos/202401/receta-capuchino-1280x720x80xX.jpg")
        )
    ),
    Restaurant(
        id = 3,
        name = "Sabor Asiático",
        description = "Platos asiáticos llenos de tradición y frescura.",
        imageUrl = "https://www.sillasmesas.es/blog/wp-content/uploads/2019/10/Decoracion-restaurantes-japoneses.jpg",
        categories = listOf("Comida Asiática", "Bebidas"),
        menu = listOf(
            Dish(11, "Sushi de Salmón", "Rollos de sushi con salmón fresco.", "https://www.oliveradatenea.com/wp-content/uploads/2023/06/Sushi-rolls-de-salmon-y-Olivada-Olivera-dAtenea.jpg"),
            Dish(12, "Ramen", "Sopa japonesa con fideos y cerdo.", "https://recetasdecocina.elmundo.es/wp-content/uploads/2025/03/ramen-receta.jpg"),
            Dish(13, "Arroz Frito", "Arroz salteado con vegetales y huevo.", "https://pittsburghfoodbank.org/wp-content/uploads/2021/08/Friend-Rice.png"),
            Dish(14, "Pollo Teriyaki", "Pollo glaseado con salsa teriyaki.", "https://imag.bonviveur.com/pollo-en-salsa-teriyaki.jpg"),
            Dish(15, "Té Verde", "Bebida tradicional japonesa.", "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/MTJ4VRJIYFEKBIZGDT3X6OSF7A.jpg")
        )
    ),
    Restaurant(
        id = 4,
        name = "Delicias Saludables",
        description = "Comida nutritiva y deliciosa para todos.",
        imageUrl = "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2023/06/19/16871657945574.jpg",
        categories = listOf("Comida Saludable", "Bebidas", "Postres y Dulces"),
        menu = listOf(
            Dish(16, "Ensalada César", "Ensalada fresca con aderezo césar.", "https://sarasellos.com/wp-content/uploads/2024/07/ensalada-cesar1.jpg"),
            Dish(17, "Wrap de Pollo", "Tortilla rellena de pollo y vegetales.", "https://i.blogs.es/7f8898/wraps-de-pollo/1366_2000.jpg"),
            Dish(18, "Smoothie de Fresa", "Batido de frutas frescas.", "https://imag.bonviveur.com/smoothie-de-fresa.jpg"),
            Dish(19, "Barra de Granola", "Barra energética con frutos secos.", "https://www.splenda.com/wp-content/uploads/2021/10/chewy-peanut-butter-chocolate-chip-granola-bars-2000x1000.jpg"),
            Dish(20, "Agua de Coco", "Bebida natural y refrescante.", "https://dorothys.farm/wp-content/uploads/2024/08/JU-AC-1l-001-agua-coco-01.jpg")
        )
    ),
    Restaurant(
        id = 5,
        name = "Dulces Momentos",
        description = "Postres que endulzan tu día.",
        imageUrl = "https://www.calemi.com/blog/wp-content/uploads/2023/08/utensilios-indispensables-heladeria.jpg",
        categories = listOf("Postres y Dulces"),
        menu = listOf(
            Dish(21, "Pastel de Chocolate", "Pastel esponjoso con chocolate.", "https://www.verybestbaking.com/sites/g/files/jgfbjl326/files/srh_recipes/6ac66e5882a6c7672cec34554a5a3a2d.jpg"),
            Dish(22, "Flan de Caramelo", "Postre cremoso con caramelo.", "https://assets.unileversolutions.com/recipes-v2/237282.jpg"),
            Dish(23, "Helado de Vainilla", "Helado clásico de vainilla.", "https://www.cocinatis.com/archivos/202308/ctis1034-receta-helado-de-vainilla-1280x720x80xX.jpg"),
            Dish(24, "Brownies", "Deliciosos brownies de chocolate.", "https://www.recipetineats.com/tachyon/2020/03/Brownies_0-SQ.jpg"),
            Dish(25, "Batido de Mango", "Bebida dulce y refrescante.", "https://www.hola.com/horizon/landscape/8fc9c11fe203-batido-mango-t.jpg")
        )
    )
)