package com.example.shoppingapp.data.models

data class Product(
    val id: Int,
    val name: String,
    val price: Double
)

 fun products(): List<Product> = listOf(
    Product(1, "Product 1", 10.0),
    Product(2, "Product 2", 15.0),
    Product(3, "Product 3", 20.0),
    Product(4, "Product 4", 25.0),
    Product(5, "Product 5", 30.0),
    Product(6, "Product 6", 35.0),
    Product(7, "Product 7", 40.0),
    Product(8, "Product 8", 45.0),
    Product(9, "Product 9", 50.0),
    Product(10, "Product 10", 55.0),
    Product(11, "Product 11", 60.0),
    Product(12, "Product 12", 65.0),
    Product(13, "Product 13", 70.0),
    Product(14, "Product 14", 75.0),
    Product(15, "Product 15", 80.0)
)
