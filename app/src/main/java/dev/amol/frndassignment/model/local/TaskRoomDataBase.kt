package dev.amol.frndassignment.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskRoomDataBase:RoomDatabase() {


    abstract fun getTaskDAO():TaskDAO
}