package com.example.petproject

import android.app.Application
import com.example.petproject.URL.URL.url
import com.example.petproject.requests.GetPerson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PersonApp: Application() {

    lateinit var personApi: GetPerson

    override fun onCreate() {
        super.onCreate()

        configurationRetrofit()
    }

    private fun configurationRetrofit() {
        val httpLoggingInterseptor = HttpLoggingInterceptor()
        httpLoggingInterseptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterseptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        personApi = retrofit.create(GetPerson::class.java)
    }

}