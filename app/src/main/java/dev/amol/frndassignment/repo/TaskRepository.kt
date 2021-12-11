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

class TaskRepository @Inject constructor(val apiService: APIService ,val taskDAO: TaskDAO) {

    fun fetchDataFromAPI(){
        CoroutineScope(IO).launch {
            val taskList:List<Task> = apiService.getAllTask(GetTaskReqData(USER_ID)).tasks
            val taskModelList= ArrayList<TaskModel>()
            taskList.forEach{
                taskModelList.add(TaskModel(it.taskId,
                    it.taskDetail.title,it.taskDetail.desc,it.taskDetail.date))
            }
            taskDAO.deleteALlTask()
            taskDAO.addTaskList(taskModelList)
        }
    }

    fun addDataToAPI(addTaskReqData: AddTaskReqData){
        CoroutineScope(IO).launch {
            apiService.storeCalendarTask(addTaskReqData)
            fetchDataFromAPI()
        }
    }

    fun deleteDataFromAPI(task_id:Int){
        CoroutineScope(IO).launch {
            apiService.deleteTask(DeleteTaskReq(task_id, USER_ID))
            fetchDataFromAPI()
        }
    }


    fun getDataFromRoom():LiveData<List<TaskModel>>{
        return taskDAO.getALlTaskList()
    }


    fun deleteTaskFromRoom(taskModel: TaskModel){
        taskDAO.deleteTask(taskModel)
    }
}