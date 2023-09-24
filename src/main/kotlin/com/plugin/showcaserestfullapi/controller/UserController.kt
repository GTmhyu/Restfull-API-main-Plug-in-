package com.plugin.showcaserestfullapi.controller

import com.plugin.showcaserestfullapi.helper.BaseResponse
import com.plugin.showcaserestfullapi.model.RegisterUserRequest
import com.plugin.showcaserestfullapi.model.UserResponse
import com.plugin.showcaserestfullapi.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (val userService : UserService)  {

    @PostMapping("/api/daftar")
    fun register(@RequestBody registerUserRequest: RegisterUserRequest) : BaseResponse<UserResponse>{
        val response = userService.register(registerUserRequest)
        return BaseResponse(
            code = 200,
            status = "Register Success",
            data = response
        )
    }
}