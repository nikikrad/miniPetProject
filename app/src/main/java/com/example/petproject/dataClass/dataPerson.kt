package com.example.petproject.dataClass

import com.google.gson.annotations.SerializedName

data class dataPerson(
    var page: String,
    var per_page: Int,
    var total: Int,
    var total_pages: Int,
    var data: List<moreDataPerson>
)
