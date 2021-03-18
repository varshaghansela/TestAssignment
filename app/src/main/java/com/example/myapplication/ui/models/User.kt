package com.example.myapplication.ui.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class UserDetailsRequest(
    var pageNumber: Int = 1,
    val limit: Int=20
)

data class UserDetailsResponse(

    val data: MutableList<User> = mutableListOf(),
    val meta: Meta,
    val message: String?,
    val code: Int,
)
data class Meta(
    val pagination: Pagination
)

data class Pagination(
    var total: Int = 1,
    var limit: Int = 20,
    var page: Int = 1,
    var pages: Int = 10
)

data class User(
    var id: Int=0,
    var name: String="",
    var email: String="",
    var gender: String="",
    var status: String="",
    var created_at: String="",
    var updated_at: String=""
)