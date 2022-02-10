package com.example.petproject.dataClass

import com.google.gson.annotations.SerializedName

data class dataPerson(
    var id: Int,
    var email: String,
    @SerializedName("first_name")
    var name: String,
    @SerializedName("last_name")
    var lastname: String,
    var avatar: String
)
