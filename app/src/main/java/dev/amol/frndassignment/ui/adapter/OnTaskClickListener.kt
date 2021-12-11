package dev.amol.frndassignment.ui.adapter

import dev.amol.frndassignment.model.local.TaskModel

interface OnTaskClickListener {
    fun onTaskClickListener(taskModel: TaskModel)
}