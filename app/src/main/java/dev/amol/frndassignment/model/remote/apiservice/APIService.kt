package dev.amol.frndassignment.model.remote.apiservice

import dev.amol.frndassignment.model.remote.requestdata.AddTaskReqData
import dev.amol.frndassignment.model.remote.requestdata.DeleteTaskReq
import dev.amol.frndassignment.model.remote.requestdata.GetTaskReqData
import dev.amol.frndassignment.model.remote.responsedata.DeleteResponse
import dev.amol.frndassignment.model.remote.responsedata.ResponseData
import retrofit2.http.*

interface APIService {

    // post request for adding task to database
    @POST("api/storeCalendarTask")
    suspend fun storeCalendarTask(@Body addTaskReqData: AddTaskReqData)

    // post request for getting list of all task
    @POST("api/getCalendarTaskLists")
    suspend fun getAllTask(@Body getTaskReqData: GetTaskReqData): ResponseData

    // request for delete single task
    @POST("api/deleteCalendarTask")
    suspend fun deleteTask(@Body deleteTaskReq: DeleteTaskReq): DeleteResponse

}

