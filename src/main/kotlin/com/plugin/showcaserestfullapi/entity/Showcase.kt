package com.plugin.showcaserestfullapi.entity

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "showcase")
data class Showcase(
    @Id
    @GeneratedValue
    val id : Int = 0,
    @Column(name = "title")
    val title : String,
    @Column(name = "image")
    val image : String,
    @Column(name = "description")
    val description : String,
    @Column(name = "created_at")
    val createdAt : Date,
    @Column(name = "updated_at")
    val updatedAt : Date
){
    @ManyToOne
    @JoinColumn(name = "id_category")
    lateinit var category : Category
}