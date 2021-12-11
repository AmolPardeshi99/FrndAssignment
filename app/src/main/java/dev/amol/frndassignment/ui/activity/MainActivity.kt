package dev.amol.frndassignment.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.amol.frndassignment.R
import dev.amol.frndassignment.model.remote.requestdata.AddTaskReqData
import dev.amol.frndassignment.model.remote.requestdata.Task
import dev.amol.frndassignment.utils.Utility.USER_ID
import dev.amol.frndassignment.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val taskViewModel: TaskViewModel by viewModels()
    private var currDate = ""
    private var title = ""
    private var decs = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            currDate = "$dayOfMonth/${month + 1}/$year"
        }

        btnAddTask.setOnClickListener {
            onAddBtnClicked()
        }

        btnShowTaskList.setOnClickListener {
            startActivity(Intent(this, TaskListActivity::class.java))
        }

    }

    private fun onAddBtnClicked() {
        title = etTitle.text.toString()
        decs = etDesc.text.toString()

        // if text-field are not empty save data to api
        if (title != "" && decs != "" && currDate != "")
            saveDataToAPI()
        else Toast.makeText(
            this,
            "The fields can't be empty. Please add task again.",
            Toast.LENGTH_SHORT
        ).show()

        // setting edittext with empty string
        etTitle.setText("")
        etDesc.setText("")
    }


    fun saveDataToAPI() {
        val task = Task(currDate, decs, title)
        taskViewModel.addDataToAPI(AddTaskReqData(task = task, userId = USER_ID))
    }

}