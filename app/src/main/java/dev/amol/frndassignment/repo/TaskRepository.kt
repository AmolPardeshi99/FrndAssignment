package dev.amol.frndassignment.repo

import androidx.lifecycle.LiveData
import dev.amol.frndassignment.model.local.TaskDAO
import dev.amol.frndassignment.model.local.TaskModel
import dev.amol.frndassignment.model.remote.apiservice.APIService
import dev.amol.frndassignment.model.remote.requestdata.AddTaskReqData
import dev.amol.frndassignment.model.remote.requestdata.DeleteTaskReq
import dev.amol.frndassignment.model.remote.requestdata.GetTaskReqData
import dev.amol.frndassignment.model.remote.responsedata.Task
import dev.amol.frndassignment.utils.Utility.USER_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskRepository @Inject constructor(val apiService: APIService, val taskDAO: TaskDAO) {

    fun fetchDataFromAPI() {
        CoroutineScope(IO).launch {
            // making api call storing response in task list
            val taskList: List<Task> = apiService.getAllTask(GetTaskReqData(USER_ID)).tasks
            val taskModelList = ArrayList<TaskModel>()

            // adding data from taskList to taskModel class for storing in room db
            taskList.forEach {
                taskModelList.add(
                    TaskModel(
                        it.taskId,
                        it.taskDetail.title, it.taskDetail.desc, it.taskDetail.date
                    )
                )
            }
            // before adding data to room db first clearing old data from room db
            taskDAO.deleteALlTask()
            taskDAO.addTaskList(taskModelList)
        }
    }

    // adding new data to api server
    fun addDataToAPI(addTaskReqData: AddTaskReqData) {
        CoroutineScope(IO).launch {
            apiService.storeCalendarTask(addTaskReqData)
            fetchDataFromAPI()
        }
    }

    // deleting data from api server
    fun deleteDataFromAPI(task_id: Int) {
        CoroutineScope(IO).launch {
            apiService.deleteTask(DeleteTaskReq(taskId = task_id, userId = USER_ID))
            fetchDataFromAPI()
        }
    }


    fun getDataFromRoom(): LiveData<List<TaskModel>> {
        return taskDAO.getALlTaskList()
    }


}