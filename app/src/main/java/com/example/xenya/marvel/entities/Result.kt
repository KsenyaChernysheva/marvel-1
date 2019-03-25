package com.example.xenya.marvel.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "result")
data class Result(
        @SerializedName("comics")
        @Embedded(prefix = "comics")
        var comics: Comics? = Comics(),
        @SerializedName("description")
        var description: String? = "",
        @SerializedName("events")
        @Embedded(prefix = "events")
        var events: Events? = Events(),
        @SerializedName("id")
        @PrimaryKey
        var id: Int = 0,
        @SerializedName("modified")
        var modified: String? = "",
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("resourceURI")
        var resourceURI: String? = "",
        @SerializedName("series")
        @Embedded(prefix = "series")
        var series: Series? = Series(),
        @SerializedName("stories")
        @Embedded(prefix = "stories")
        var stories: Stories? = Stories(),
        @SerializedName("thumbnail")
        @Embedded(prefix = "thumbnail")
        var thumbnail: Thumbnail? = Thumbnail(),
        @SerializedName("urls")
        @Ignore
        var urls: List<Url?>? = listOf()
)
