package com.example.shoppingapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.data.models.Product
import com.example.shoppingapp.data.models.products
import com.example.shoppingapp.viewmodels.ProductsViewmodel

@Composable
fun ProductScreen(navController: NavController,productsViewModel: ProductsViewmodel) {
    val products = remember { products() }
    val context = LocalContext.current


    Column {
        LazyColumn {
            items(products) { product ->
                ProductItem(product) {
                    productsViewModel.addProduct(product)
                    Toast.makeText(context,"${product.name} added to cart",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, onAddToCheckout: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = product.name)
        Text(text = "\$${product.price}")
        Button(onClick = onAddToCheckout) {
            Text("Add")
        }
    }
}
