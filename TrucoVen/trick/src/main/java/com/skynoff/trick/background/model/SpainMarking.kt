package com.skynoff.trick.background.model

import com.skynoff.base.R
import com.skynoff.base.model.Marking

sealed class SpainMarking : Marking {

 class Cup : SpainMarking() {
        val name: String = "Copa"
        override fun getMarkSrc(): Int = R.drawable.cup_pint

        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 13
                else -> value
            }
    }

 class Gold : SpainMarking() {
        val name: String = "Oro"
        override fun getMarkSrc(): Int = R.drawable.gold_pint

        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 13
                7 -> 16
                else -> value
            }
    }

 class Coarse : SpainMarking() {
        val name: String = "Bastos"
        override fun getMarkSrc(): Int = R.drawable.coarse_pint

        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 18
                else -> value
            }
    }

 class Sword : SpainMarking() {
        val name: String = "Espada"
        override fun getMarkSrc(): Int = R.drawable.sword_pint

        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 19
                7 -> 17
                else -> value
            }
    }
}
