package com.example.petproject.requests

import retrofit2.Call
import com.example.petproject.dataClass.dataPerson
import retrofit2.http.GET

interface GetPerson {

    @GET("users?page=2")
    fun getPerson(): Call<List<dataPerson>>

}