package com.example.xenya.marvel.entities

import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class Events(
        @SerializedName("available")
        var available: String? = "",
        @SerializedName("collectionURI")
        var collectionURI: String? = "",
        @SerializedName("items")
        @Ignore
        var items: List<ItemX?>? = listOf(),
        @SerializedName("returned")
        var returned: String? = ""
)
