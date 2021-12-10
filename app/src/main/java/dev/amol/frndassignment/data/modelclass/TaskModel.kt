package dev.amol.frndassignment.data.modelclass

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "taskList")
data class TaskModel(
    @ColumnInfo(name = "title")var title:String,
    @ColumnInfo(name = "desc")var desc:String,
    @ColumnInfo(name = "date")var date:String
)
