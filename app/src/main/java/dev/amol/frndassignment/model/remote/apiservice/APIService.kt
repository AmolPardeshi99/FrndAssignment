package dev.amol.frndassignment.model.remote.apiservice

import dev.amol.frndassignment.model.remote.requestdata.AddTaskReqData
import dev.amol.frndassignment.model.remote.requestdata.DeleteTaskReq
import dev.amol.frndassignment.model.remote.requestdata.GetTaskReqData
import dev.amol.frndassignment.model.remote.responsedata.ResponseData
import dev.amol.frndassignment.model.remote.responsedata.Task
import dev.amol.frndassignment.model.remote.responsedata.TaskDetail
import retrofit2.http.*

interface APIService {

    // post request for adding task to database
    @POST("api/storeCalendarTask")
    suspend fun storeCalendarTask(@Body addTaskReqData: AddTaskReqData)

    // post request for getting list of all task
    @POST("api/getCalendarTaskLists")
    suspend fun getAllTask(@Body getTaskReqData: GetTaskReqData): ResponseData

    // request for delete single task
    @POST("api/storeCalendarTask")
    suspend fun deleteTask(@Body deleteTaskReq: DeleteTaskReq)

}




//
//
//@Multipart
//@POST("api/storeCalendarTask")
//suspend fun storeCalendarTask(
//    @Part("user_id")user_id: Int,
//    @Part("task")task: TaskDetail
//)
//
//// post request for getting list of all task
//@FormUrlEncoded
//@POST("api/getCalendarTaskLists")
//suspend fun getAllTask(
//    @Field("user_id") user_id:Int
//): ResponseData
//
//// request for delete single task
//@FormUrlEncoded
//@POST("api/storeCalendarTask")
//suspend fun deleteTask(
//    @Field("user_id")user_id: Int,
//    @Field("task_id")task_id:Int
//)