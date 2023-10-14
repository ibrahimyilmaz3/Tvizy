package com.application.tvizy.model

data class Reel(
    var image: Int,
    var channel: Int,
    var description: String,
    var product: ArrayList<Product>?
) {

}