package com.skynoff.trick.background.model

import com.skynoff.base.R
import com.skynoff.base.model.Marking

sealed class SpainMarking : Marking {

    class Cup : SpainMarking() {
        val name: String = "cup"
        override fun getMarkSrc(): String = name
        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 13
                else -> value
            }
    }

    class Gold : SpainMarking() {
        val name: String = "gold"
        override fun getMarkSrc(): String = name
        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 13
                7 -> 16
                else -> value
            }
    }

    class Coarse : SpainMarking() {
        val name: String = "coarse"
        override fun getMarkSrc(): String = name
        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 18
                else -> value
            }
    }

    class Sword : SpainMarking() {
        val name: String = "sword"
        override fun getMarkSrc(): String = name
        override fun getGameValue(value: Int): Int =
            when (value) {
                1 -> 19
                7 -> 17
                else -> value
            }
    }
}
