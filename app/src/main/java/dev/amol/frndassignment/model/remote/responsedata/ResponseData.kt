package dev.amol.frndassignment.model.remote.responsedata


import com.google.gson.annotations.SerializedName

// response data class for fetching data from api
data class ResponseData(
    @SerializedName("tasks")
    val tasks: List<Task>
)