package com.example.xenya.marvel.entities

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Test(
        @SerializedName("attributionHTML")
        var attributionHTML: String? = "",
        @SerializedName("attributionText")
        var attributionText: String? = "",
        @SerializedName("code")
        var code: String? = "",
        @SerializedName("copyright")
        var copyright: String? = "",
        @SerializedName("data")
        @Embedded(prefix = "data")
        var data: Data? = Data(),
        @SerializedName("etag")
        var etag: String? = "",
        @SerializedName("status")
        var status: String? = ""
)
