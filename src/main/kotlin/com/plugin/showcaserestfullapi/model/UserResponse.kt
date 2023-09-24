package com.plugin.showcaserestfullapi.model

import java.util.Date

data class UserResponse (
    val id : Int,
    val name : String,
    val email : String,
    val createdAt : Date,
    val updatedAt : Date
)