package com.skynoff.base.factories

import com.skynoff.base.model.Card
import com.skynoff.base.model.Mark
import com.skynoff.base.model.Marking


interface CardFactory {
    fun createCard(number:Int,marking: Mark): Card
}