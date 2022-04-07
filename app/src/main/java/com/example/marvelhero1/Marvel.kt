package com.example.marvelhero1

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Marvel (
    @SerializedName("name")
    val name: String,
    @SerializedName("realname")
    val realname: String,
    @SerializedName("team")
    val team: String,
    @SerializedName("createdby")
    val createdby: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("firstappearance")
    val firstappearance: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("imageurl")
    val imageurl: String
        ): Serializable
