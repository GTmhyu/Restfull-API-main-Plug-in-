package com.plugin.showcaserestfullapi.service.impl

import com.plugin.showcaserestfullapi.entity.User
import com.plugin.showcaserestfullapi.helper.ValidationUtil
import com.plugin.showcaserestfullapi.model.RegisterUserRequest
import com.plugin.showcaserestfullapi.model.UserResponse
import com.plugin.showcaserestfullapi.repository.UserRepository
import com.plugin.showcaserestfullapi.service.UserService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val userRepository: UserRepository, val validationUtil: ValidationUtil, val bcrypt : BCryptPasswordEncoder) : UserService {

    private fun convertUserToUserResponse(user : User) : UserResponse{
        return UserResponse(
            id = user.id,
            name = user.name,
            email = user.email,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }

    override fun register(registerUserRequest: RegisterUserRequest): UserResponse {
        validationUtil.validate(registerUserRequest)
        val user = User(
            name = registerUserRequest.name,
            email = registerUserRequest.email,
            password = bcrypt.encode(registerUserRequest.password),
            createdAt = Date(),
            updatedAt = Date()
        )
        userRepository.save(user)
        return convertUserToUserResponse(user)
    }

}