package com.plugin.showcaserestfullapi.service

import com.plugin.showcaserestfullapi.entity.UserSecurity
import com.plugin.showcaserestfullapi.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDetailService(private val repository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        // Create a method in your repo to find a user by its username
        val user = repository.findByEmail(username) ?: throw UsernameNotFoundException("$username not found")
        return UserSecurity(
            user.id.toString(),
            user.email,
            user.password,
            Collections.singleton(SimpleGrantedAuthority("user"))
        )
    }

}