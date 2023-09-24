package com.plugin.showcaserestfullapi.service

import com.plugin.showcaserestfullapi.model.RegisterUserRequest
import com.plugin.showcaserestfullapi.model.UserResponse



interface UserService {
    fun register(registerUserRequest: RegisterUserRequest) : UserResponse
}