package dev.amol.frndassignment.model.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDAO {

    // insert data to room db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTaskList(taskList: List<TaskModel>)

    // delete data from room
    @Delete
    fun deleteTask(taskModel: TaskModel)

    // fetch all data from taskList table
    @Query("select * from taskList order by date")
    fun getALlTaskList(): LiveData<List<TaskModel>>


    // delete all task before adding fresh task
    @Query("delete from taskList")
    fun deleteALlTask()

}