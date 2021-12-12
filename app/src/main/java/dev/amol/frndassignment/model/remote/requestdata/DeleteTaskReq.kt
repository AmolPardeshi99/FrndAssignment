package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

// request data class for deleting data from api
data class DeleteTaskReq(
    @SerializedName("task_id")
    val taskId: Int,
    @SerializedName("user_id")
    val userId: Int
)