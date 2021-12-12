package dev.amol.frndassignment.model.remote.responsedata


import com.google.gson.annotations.SerializedName

// response data class for deleting data to api
data class DeleteResponse(
    @SerializedName("status")
    val status: String
)