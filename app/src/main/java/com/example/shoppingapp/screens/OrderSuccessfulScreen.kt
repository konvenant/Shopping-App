package com.example.shoppingapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.viewmodels.ProductsViewmodel

@Composable
fun OrderSuccessfulScreen(navController: NavController, productsViewModel: ProductsViewmodel) {
   val totalProducts = productsViewModel.checkoutItems.toList()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {


            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .align(Alignment.Center)
            ){
                if(totalProducts.isNotEmpty()){
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = "Order Successful! for ${totalProducts.size} products",
                    style = MaterialTheme.typography.headlineMedium
                )
                } else{
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.Red,
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "No Product added to cart, Go back and add product to cart",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Red)
                }
            }

    }
}
