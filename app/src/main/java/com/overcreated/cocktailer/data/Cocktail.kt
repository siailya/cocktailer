package com.overcreated.cocktailer.data

import kotlinx.serialization.Serializable

@Serializable
data class Cocktail(
    override val name: String,
    override val ingredients: List<List<String>>,
    override val strengthDegrees: Float,
    override val foodCost: Float,
    override val description: String,
    override val commonName: String,
    override val image: String,
    override val fullDescription: String,
    override val standardVolume: String,
    override val receipt: List<String>
) : ICocktail {
}