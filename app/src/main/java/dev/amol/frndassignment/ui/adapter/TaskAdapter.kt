package dev.amol.frndassignment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.amol.frndassignment.R
import dev.amol.frndassignment.model.local.TaskModel
import kotlinx.android.synthetic.main.itemlayout.view.*

// adapter and viewholder classes for showing taskList recyclerView
class TaskAdapter(
    private val onTaskClickListener: OnTaskClickListener,
    private val taskList: MutableList<TaskModel>
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false),
            onTaskClickListener
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val result = taskList[position]
        holder.setData(result)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }



    class TaskViewHolder(val view: View, val onTaskClickListener: OnTaskClickListener) :
        RecyclerView.ViewHolder(view) {

        // setting data to ui components
        fun setData(taskModel: TaskModel) {
            view.apply {
                tvTaskTitle.text = taskModel.title
                tvTaskDate.text = taskModel.date
                tvTaskDesc.text = taskModel.desc

                // clickListener for delete button on each task
                btnDeleteTask.setOnClickListener {
                    onTaskClickListener.onTaskClickListener(taskModel)
                }
            }
        }
    }

}