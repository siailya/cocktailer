package com.overcreated.cocktailer.data

interface IIngredient {
    val name: String
    val description: String
    val cost: Float
    val strengthDegrees: Float
    val isAlcohol: Boolean
}