package dev.amol.frndassignment.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


// entity class fro taskList table
@Entity(tableName = "taskList")
data class TaskModel(
    @PrimaryKey
    @ColumnInfo(name = "task_id") val task_id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "date") var date: String
) : Serializable
