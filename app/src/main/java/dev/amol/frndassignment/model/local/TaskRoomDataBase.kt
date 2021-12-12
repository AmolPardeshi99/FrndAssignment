package dev.amol.frndassignment.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

// database class for room db
@Database(entities = [TaskModel::class], version = 1)
abstract class TaskRoomDataBase:RoomDatabase() {

    // getting instance of dao class
    abstract fun getTaskDAO():TaskDAO
}