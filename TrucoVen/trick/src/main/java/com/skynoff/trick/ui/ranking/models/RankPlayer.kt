package com.skynoff.trick.ui.ranking.models

import com.skynoff.base.model.GamePlayer

data class RankPlayer(
    val name:String,
    val points:Int,
    val player: GamePlayer
)
