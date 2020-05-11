package com.skynoff.trick.background.model

import com.skynoff.base.model.Card
import com.skynoff.base.model.Deck
import com.skynoff.base.model.Mark

class SpainDeck : Deck {
    var fullSpainDeck = mutableListOf<Card>()
    override fun createFullDeck() {

        SpainMark.values().forEach {
            fullSpainDeck.addAll(createMarkDeck(it))
        }
    }

    override fun createMarkDeck(mark: Mark): MutableList<Card> =
        (1..12).asSequence().filterNot { it in 8..9 }.map { cardNumber ->
            val spainCard = SpainCard.Builder(cardNumber)
            spainCard.setMarking(mark as SpainMark)
            spainCard.build()
        }.toMutableList()
}

enum class SpainMark(val markName: String = "") : Mark {
    GOLD("gold"),
    COARSE("coarse"),
    CUP("cup"),
    SWORD("sword");
}