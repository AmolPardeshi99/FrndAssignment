package dev.amol.frndassignment.ui.adapter

import dev.amol.frndassignment.model.local.TaskModel

// clickListener for delete button on each task
interface OnTaskClickListener {
    fun onTaskClickListener(taskModel: TaskModel)
}