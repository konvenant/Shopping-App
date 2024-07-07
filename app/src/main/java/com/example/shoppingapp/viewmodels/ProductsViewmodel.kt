package com.example.shoppingapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.models.Product

class ProductsViewmodel : ViewModel() {
    val checkoutItems = mutableStateListOf<Product>()
    val totalSumOfProduct = mutableIntStateOf(0)

    fun addProduct(product: Product) {
        if (!checkoutItems.contains(product)) {
            checkoutItems.add(product)
            totalSumOfProduct.intValue = calculateSumOfProduct()
        }
    }

    fun removeProduct(product: Product) {
        checkoutItems.remove(product)
       totalSumOfProduct.intValue = calculateSumOfProduct()
    }

    fun getCheckedProduct() : List<Product>  {
        return checkoutItems
    }

    private fun calculateSumOfProduct() : Int {
        var price = 0
        checkoutItems.map {
            price += it.price.toInt()
        }

        return price
    }
}