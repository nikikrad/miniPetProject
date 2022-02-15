package com.example.petproject.requests

import com.example.petproject.dataClass.dataPerson
import retrofit2.Response
import retrofit2.http.GET

interface GetPerson {

    @GET("users?page=2")
    fun getPerson():  Response<dataPerson>

}