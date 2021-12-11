package dev.amol.frndassignment.model.remote.responsedata


import com.google.gson.annotations.SerializedName


data class TaskDetail(
    @SerializedName("date")
    val date: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("title")
    val title: String
)