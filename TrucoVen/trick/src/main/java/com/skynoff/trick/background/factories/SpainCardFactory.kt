package com.skynoff.trick.background.factories

import com.skynoff.base.factories.CardFactory
import com.skynoff.base.model.Card
import com.skynoff.base.model.Mark
import com.skynoff.trick.background.model.SpainCard
import com.skynoff.trick.background.model.SpainMark

class SpainCardFactory : CardFactory {

    override fun createCard(number:Int,marking: Mark): Card {
        val cardBuild = SpainCard.Builder(number)
        cardBuild.setMarking(marking as SpainMark)
        return cardBuild.build()
    }
}