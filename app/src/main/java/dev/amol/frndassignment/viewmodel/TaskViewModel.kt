package dev.amol.frndassignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.amol.frndassignment.model.local.TaskModel
import dev.amol.frndassignment.model.remote.requestdata.AddTaskReqData
import dev.amol.frndassignment.repo.TaskRepository
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(val taskRepo: TaskRepository) : ViewModel() {

    // getting data from room db
    fun getDataFromRoomDB(): LiveData<List<TaskModel>> {
        return taskRepo.getDataFromRoom()
    }

    // fetching current data from api server
    fun fetchDataFromAPI() {
        taskRepo.fetchDataFromAPI()
    }

    // adding new data to api server
    fun addDataToAPI(taskReqData: AddTaskReqData) {
        taskRepo.addDataToAPI(taskReqData)
    }

    // delete current data from api server
    fun deleteFromAPI(task_id: Int) {
        taskRepo.deleteDataFromAPI(task_id)
    }


}