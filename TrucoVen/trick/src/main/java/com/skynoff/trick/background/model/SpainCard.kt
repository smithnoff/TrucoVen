package com.skynoff.trick.background.model

import com.skynoff.base.model.Card
import com.skynoff.base.model.Mark
import com.skynoff.base.model.Marking

class SpainCard private constructor(
    override val number: Int,
    override val marking: Marking,
    override val gameValue: Int,
    override var isFaceUp: Boolean
) : Card {

    override fun getGameValue() {

    }

    override fun getMark() {
    }

    override fun setfacing(isFaceUp: Boolean) {
        this.isFaceUp = isFaceUp
    }

    class Builder(private val number: Int) {
        var marking: Marking = SpainMarking.Gold()
        var isFaceUp: Boolean = true
        fun setMarking(spainMark: SpainMark) {

            marking = when (spainMark) {
                SpainMark.GOLD -> SpainMarking.Gold()
                SpainMark.COARSE -> SpainMarking.Coarse()
                SpainMark.CUP -> SpainMarking.Cup()
                SpainMark.SWORD -> SpainMarking.Sword()
            }
        }

        fun setFacing(isfaceUp: Boolean) {
            this.isFaceUp = isfaceUp
        }

        fun build() =
            SpainCard(number, marking, marking.getGameValue(number), isFaceUp)
    }
}