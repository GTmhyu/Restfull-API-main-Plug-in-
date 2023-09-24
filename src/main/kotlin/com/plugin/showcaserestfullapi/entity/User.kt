package com.plugin.showcaserestfullapi.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue
    val id : Int = 0,

    @Column(name = "name")
    var name : String,

    @Column(name = "email")
    var email : String,

    @Column(name = "password")
    var password : String,

    @Column(name = "created_at")
    val createdAt : Date,

    @Column(name = "updated_at")
    var updatedAt : Date
)
