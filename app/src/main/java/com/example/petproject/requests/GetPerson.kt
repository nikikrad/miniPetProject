package com.example.petproject.requests

import com.example.petproject.dataClass.dataPerson
import io.reactivex.Single
import retrofit2.http.GET

interface GetPerson {

    @GET("users?page=2")
    fun getPerson(): Single<dataPerson>

}