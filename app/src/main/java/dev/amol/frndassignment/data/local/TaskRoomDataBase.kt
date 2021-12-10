package dev.amol.frndassignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class TaskRoomDataBase:RoomDatabase() {

    abstract fun getTaskDAO():TaskDAO
}