package com.overcreated.cocktailer.data


interface ICocktail {
    val name: String
    val commonName: String
    val description: String
    val ingredients: List<PreparedIngredient>
    val strengthDegrees: Float
    val foodCost: Float
    val image: String
}