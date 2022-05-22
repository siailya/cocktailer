package com.overcreated.cocktailer.data

/**
 * Интерфейс коктейля
 *
 * @property name: String - название коктейля
 * @property commonName: String - название на оригинальном языке
 * @property description: String - описание в карточке
 * @property fullDescription: String - описание в просмотрщике
 * @property standardVolume: String - стандартный объем
 * @property ingredients: List<List<String>> - Список ингредиентов в формате [["Водка", "40мл"], ["Сок", "50мл"]]
 * @property strengthDegrees: Float - средняя крепость
 * @property foodCost: Float - средняя себестоимость
 * @property image: String - URL картинки
 */
interface ICocktail {
    val name: String
    val commonName: String
    val description: String // Описание в карточке
    val fullDescription: String //
    val standardVolume: String
    val ingredients: List<List<String>>
    val strengthDegrees: Float
    val foodCost: Float
    val image: String
    val receipt: List<String>
}