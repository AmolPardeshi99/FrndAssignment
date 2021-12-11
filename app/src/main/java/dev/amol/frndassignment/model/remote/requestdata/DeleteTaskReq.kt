package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

data class DeleteTaskReq(
    @SerializedName("task_id")
    val taskId: Int,
    @SerializedName("user_id")
    val userId: Int
)