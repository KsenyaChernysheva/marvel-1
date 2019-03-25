package com.example.xenya.marvel.entities

import com.google.gson.annotations.SerializedName

data class ItemX(
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("resourceURI")
        var resourceURI: String? = ""
)
