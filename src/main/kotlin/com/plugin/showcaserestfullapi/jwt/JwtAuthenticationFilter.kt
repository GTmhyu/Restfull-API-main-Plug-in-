package com.plugin.showcaserestfullapi.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import com.plugin.showcaserestfullapi.entity.UserSecurity
import com.plugin.showcaserestfullapi.model.LoginRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(
    private val jwtTokenUtil: JwtTokenUtil,
    private val authenticationManager: AuthenticationManager
) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(req: HttpServletRequest, response: HttpServletResponse): Authentication {
        val credentials = ObjectMapper().readValue(req.inputStream, LoginRequest::class.java)
        val auth = UsernamePasswordAuthenticationToken(
            credentials.email,
            credentials.password,
            Collections.singleton(SimpleGrantedAuthority("user"))
        )
        return authenticationManager.authenticate(auth)
    }

    override fun successfulAuthentication(req : HttpServletRequest?, res : HttpServletResponse?, chain : FilterChain?, auth : Authentication){
        val username = (auth.principal as UserSecurity).username
        val token = jwtTokenUtil.generateToken(username)
        res?.addHeader("Auhtorization", token)
        res?.addHeader("Access-Control-Expose-Headers", "Authorization")
        res?.contentType = "application/json"
        val map = mutableMapOf<String, String>()
        map.put("access_token", token)
        ObjectMapper().writeValue(res?.outputStream, map)
    }

    override fun unsuccessfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        failed: AuthenticationException
    ) {
        val error = BadCredentialsError()
        response.status = error.status
        response.contentType = "application/json"
        response.writer.append(error.toString())
    }
}

private data class BadCredentialsError(
    val timestamp: Long = Date().time,
    val status: Int = 401,
    val message: String = "Email or password incorrect",
) {
    override fun toString(): String {
        return ObjectMapper().writeValueAsString(this)
    }
}