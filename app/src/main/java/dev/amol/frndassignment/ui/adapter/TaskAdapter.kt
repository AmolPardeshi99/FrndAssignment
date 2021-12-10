package dev.amol.frndassignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.amol.frndassignment.R
import dev.amol.frndassignment.data.modelclass.TaskModel

class TaskAdapter(
    val context: Context,
    private val taskList: MutableList<TaskModel>
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(val itemlayoutBinding: ItemlayoutBinding): RecyclerView.ViewHolder(itemlayoutBinding.root){
        fun setData(taskModel: TaskModel){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.itemlayout,parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val result = taskList[position]
        holder.setData(result)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}