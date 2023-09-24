package com.plugin.showcaserestfullapi.model

import javax.validation.constraints.NotBlank

data class RegisterUserRequest(
    @field:NotBlank
    val name : String,
    @field:NotBlank
    val email : String,
    @field:NotBlank
    val password : String
)
