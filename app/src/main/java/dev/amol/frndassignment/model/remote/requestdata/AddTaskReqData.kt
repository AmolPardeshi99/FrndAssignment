package dev.amol.frndassignment.model.remote.requestdata


import com.google.gson.annotations.SerializedName

// request data class for adding data to api
data class AddTaskReqData(
    @SerializedName("task")
    val task: Task,
    @SerializedName("user_id")
    val userId: Int
)