package com.example.shoppingapp.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.viewmodels.ProductsViewmodel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(productsViewmodel: ProductsViewmodel) {
    val navController = rememberNavController()
    val viewModel = ProductsViewmodel()
    Scaffold(
        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = currentRoute(navController) == "products",
                    onClick = { navController.navigate("products") },
                    label = { Text("Products") },
                    icon = { Icon(Icons.Default.List, contentDescription = null) }
                )
                NavigationBarItem(
                    selected = currentRoute(navController) == "checkout",
                    onClick = { navController.navigate("checkout") },
                    label = { Text("Checkout") },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "products") {
            composable("products") { ProductScreen(navController,productsViewmodel) }
            composable("checkout") { CheckoutScreen(navController,productsViewmodel) }
            composable("order_successful") { OrderSuccessfulScreen(navController,productsViewmodel) }
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
fun MyApp(productsViewmodel: ProductsViewmodel) {
    MainScreen(productsViewmodel)
}



