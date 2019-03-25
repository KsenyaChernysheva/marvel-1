package com.example.xenya.marvel.entities

import com.google.gson.annotations.SerializedName

data class Item(
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("resourceURI")
        var resourceURI: String? = "",
        @SerializedName("type")
        var type: String? = ""
)
