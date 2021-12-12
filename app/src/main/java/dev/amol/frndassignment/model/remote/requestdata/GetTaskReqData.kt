package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

// request data class for fetching all data from api
data class GetTaskReqData(
    @SerializedName("user_id")
    val userId: Int
)