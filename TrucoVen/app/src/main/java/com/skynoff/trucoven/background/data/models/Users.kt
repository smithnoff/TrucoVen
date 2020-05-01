package com.skynoff.trucoven.background.data.models

data class Users(
    val name:String,
    val alias:String,
    val avatar:String,
    val password:String,
    val email: String,
    val ranking:GameRanking
)