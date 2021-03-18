package com.example.myapplication.retrofit

import com.example.myapplication.ui.models.UserDetailsResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiInterface {

    // https://gorest.co.in/public-api/users
    @GET("public-api/users")
    fun getUserMaster(): Observable<UserDetailsResponse>

}
