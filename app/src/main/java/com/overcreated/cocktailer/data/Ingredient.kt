package com.overcreated.cocktailer.data

import kotlinx.serialization.Serializable

@Serializable
class Ingredient(
    override val name: String,
    override val description: String,
    override val cost: Float,
    override val strengthDegrees: Float,
    override val isAlcohol: Boolean
) : IIngredient


interface IPreparedIngredient {
    val ingredient: Ingredient
    val volume: Float
}

class PreparedIngredient(
    override val ingredient: Ingredient,
    override val volume: Float
) : IPreparedIngredient