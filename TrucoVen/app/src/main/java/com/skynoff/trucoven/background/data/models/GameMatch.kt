package com.skynoff.trucoven.background.data.models

data class GameMatch(
    val gameSetNumber: Int,
    val gameSet: GameSet,
    val gameCurrentPoints: Int,
    val gameMaxPoints: Int
)