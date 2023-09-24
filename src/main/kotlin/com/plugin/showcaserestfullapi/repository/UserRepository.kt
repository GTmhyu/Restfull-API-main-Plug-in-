package com.plugin.showcaserestfullapi.repository

import com.plugin.showcaserestfullapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {
    fun findByEmail(email : String) : User
}