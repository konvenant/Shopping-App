package com.example.shoppingapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.data.models.Product
import com.example.shoppingapp.viewmodels.ProductsViewmodel

@Composable
fun CheckoutScreen(navController: NavController,productsViewModel: ProductsViewmodel) {
    val checkoutItems = remember { productsViewModel.checkoutItems }
    val totalPrice = remember {productsViewModel.totalSumOfProduct }

    Column {
        LazyColumn {
            items(checkoutItems) { product ->
                CheckoutItem(product) {
                    productsViewModel.removeProduct(product)
                }
            }

            item {
                Box (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (checkoutItems.isNotEmpty()){
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .padding(4.dp)
                                .align(Alignment.CenterEnd),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Total")
                            ElevatedButton(
                                onClick = {},
                                elevation = ButtonDefaults.buttonElevation(4.dp)
                            ) {
                                Text(text = "$${totalPrice.intValue}")
                            }
                        }
                    } else{
                        Text(
                            text = "Unable to checkout due to empty cart, navigate to products to add products",
                            color = Color.Red,
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
        Button(
            onClick = {
                navController.navigate("order_successful")

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            enabled = checkoutItems.isNotEmpty()
        ) {
            Text("Place Order")
        }
    }
}

@Composable
fun CheckoutItem(product: Product, onRemoveFromCheckout: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = product.name)
        Text(text = "\$${product.price}")
        Button(onClick = onRemoveFromCheckout) {
            Text("Remove")
        }
    }
}


