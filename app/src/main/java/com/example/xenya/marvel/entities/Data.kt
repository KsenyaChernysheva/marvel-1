package com.example.xenya.marvel.entities

import com.google.gson.annotations.SerializedName

data class Data(
        @SerializedName("count")
        var count: String? = "",
        @SerializedName("limit")
        var limit: String? = "",
        @SerializedName("offset")
        var offset: String? = "",
        @SerializedName("results")
        var results: List<Result?>? = listOf(),
        @SerializedName("total")
        var total: String? = ""
)
