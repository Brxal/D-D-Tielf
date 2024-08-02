package com.alexquispe.ddtielf

import java.io.Serializable

data class Character(
    val name: String,
    val race: String,
    val characterClass: String,
    val description: String
) : Serializable
