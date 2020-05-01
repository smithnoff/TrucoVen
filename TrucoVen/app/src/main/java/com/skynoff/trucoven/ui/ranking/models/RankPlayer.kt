package com.skynoff.trucoven.ui.ranking.models

import com.skynoff.trucoven.background.data.models.GamePlayer

data class RankPlayer(
    val name:String,
    val points:Int,
    val player:GamePlayer
)
