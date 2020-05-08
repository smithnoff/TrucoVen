package com.skynoff.base.model

data class Deck(
    val number: Int = 0,
    val marking: Marking,
    val playValue:Int=0
)

sealed class Marking() {
    data class Cup(val name: String = "Copa") : Marking()
    data class Gold(val name: String = "Oro") : Marking()
    data class Coarse(val name: String = "Batsos") : Marking()
    data class Sword(val name: String = "Espada") : Marking()
}