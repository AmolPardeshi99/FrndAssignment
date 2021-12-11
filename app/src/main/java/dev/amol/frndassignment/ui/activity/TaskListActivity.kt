package dev.amol.frndassignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.frndassignment.R
import dev.amol.frndassignment.model.local.TaskModel
import dev.amol.frndassignment.ui.adapter.OnTaskClickListener
import dev.amol.frndassignment.ui.adapter.TaskAdapter
import dev.amol.frndassignment.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.activity_task_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaskListActivity : AppCompatActivity(),OnTaskClickListener {

    val taskViewModel:TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter
    private var taskList = ArrayList<TaskModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        loadData()
        setRecycler()
    }

    private fun loadData() {
        CoroutineScope(Main).launch {
            taskViewModel.fetchDataFromAPI()
        }
        taskViewModel.getDataFromRoomDB().observe(this, Observer {
            taskList.clear()
            taskList.addAll(it)
            taskAdapter.notifyDataSetChanged()
        })
    }


    private fun setRecycler() {
        taskAdapter = TaskAdapter(this,taskList)
        taskRecyclerView.apply {
            adapter = taskAdapter
            layoutManager=LinearLayoutManager(this@TaskListActivity)
        }
    }

    override fun onTaskClickListener(taskModel: TaskModel) {
        taskViewModel.deleteFromAPI(taskModel.task_id)
    }
}