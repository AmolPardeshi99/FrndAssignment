package dev.amol.frndassignment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import dev.amol.frndassignment.data.modelclass.TaskModel

@Dao
interface TaskDAO {

    // insert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTaskList(taskList: ArrayList<TaskModel>)

    // delete data


    // fetch all data



}