package com.skynoff.base.model

interface Card {
    val number: Int
    val marking: Marking
    val gameValue: Int
    var isFaceUp: Boolean

    fun getGameValue()
    fun getMark()
    fun setfacing(isFaceUp:Boolean)
}