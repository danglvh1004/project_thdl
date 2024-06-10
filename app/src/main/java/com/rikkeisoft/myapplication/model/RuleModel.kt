package com.rikkeisoft.myapplication.model

import kotlin.random.Random

data class RuleModel(
    var element : String = "",
    var startRule: String = "",
    var endRule: String = "",
    val id: String = Random.toString()
)