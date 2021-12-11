package dev.amol.frndassignment.model.remote.responsedata


import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("tasks")
    val tasks: List<Task>
)