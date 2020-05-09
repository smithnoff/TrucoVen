package com.skynoff.base.model

interface Deck {

    fun createFullDeck()
    fun createMarkDeck(mark: Mark):Collection<Card>

}

