package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

data class GetTaskReqData(
    @SerializedName("user_id")
    val userId: Int
)