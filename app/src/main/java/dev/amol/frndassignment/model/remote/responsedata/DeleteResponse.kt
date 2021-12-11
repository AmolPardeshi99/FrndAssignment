package dev.amol.frndassignment.model.remote.responsedata


import com.google.gson.annotations.SerializedName

data class DeleteResponse(
    @SerializedName("status")
    val status: String
)