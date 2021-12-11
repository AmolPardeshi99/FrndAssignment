package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("date")
    val date: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("title")
    val title: String
)