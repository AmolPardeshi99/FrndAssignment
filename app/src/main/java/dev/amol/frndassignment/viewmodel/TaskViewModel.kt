package dev.amol.frndassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.frndassignment.model.local.TaskModel
import dev.amol.frndassignment.model.remote.requestdata.AddTaskReqData
import dev.amol.frndassignment.repo.TaskRepository
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(val taskRepo: TaskRepository):ViewModel() {


    fun getDataFromRoomDB():LiveData<List<TaskModel>>{
        return taskRepo.getDataFromRoom()
    }

    fun fetchDataFromAPI(){
        taskRepo.fetchDataFromAPI()
    }

    fun addDataToAPI(taskReqData: AddTaskReqData){
        taskRepo.addDataToAPI(taskReqData)
    }

    fun deleteFromAPI(task_id:Int){
        taskRepo.deleteDataFromAPI(task_id )
    }

    fun deleteFromRoomDB(taskModel: TaskModel){
        taskRepo.deleteTaskFromRoom(taskModel)
    }

}