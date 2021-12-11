package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

data class AddTaskReqData(
    @SerializedName("task")
    val task: Task,
    @SerializedName("user_id")
    val userId: Int
)