package com.example.petproject.servises

import android.util.Log
import com.example.petproject.URL.URL.url
import com.example.petproject.dataClass.dataPerson
import com.example.petproject.requests.GetPerson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Person {


    var personsList: MutableList<dataPerson> = emptyList<dataPerson>().toMutableList()
    private val URL = url

    fun start(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val myApi = retrofit.create(GetPerson::class.java)

        val call = myApi.getPerson()
        call.enqueue(object: Callback<List<dataPerson>> {

            override fun onResponse(
                call: Call<List<dataPerson>>,
                response: Response<List<dataPerson>>
            ) {
                if (response.isSuccessful){
                    if(response.isSuccessful) {
                        val person = response.body()
                        if (person != null) {
                            for (i in 0 until person.count()) {
                                val id = person[i].id
                                val email = person[i].email
                                val name = person[i].name
                                val surname = person[i].lastname
                                val avatar = person[i].avatar
                                personsList.add(dataPerson(id, email, name, surname, avatar))
                            }
                        }
                    }
                }else Log.e("KEK", "ERROR")
            }

            override fun onFailure(call: Call<List<dataPerson>>, t: Throwable) {
                Log.e("KEK", t.toString())
            }

        })

    }
}
