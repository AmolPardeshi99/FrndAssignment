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

    // initializing variables
    val taskViewModel: TaskViewModel by viewModels()
    private var currDate = ""
    private var title = ""
    private var decs = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // on selecting date store date in variable
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            currDate = "$dayOfMonth/${month + 1}/$year"
        }

        // on click of add task button add task to room and api server
        btnAddTask.setOnClickListener {
            onAddBtnClicked()
        }

        // on click of show task button open new activity for showing task list
        btnShowTaskList.setOnClickListener {
            startActivity(Intent(this, TaskListActivity::class.java))
        }

    }

    // function for getting values from edittext validation
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

    // saving new task to api server
    fun saveDataToAPI() {
        val task = Task(currDate, decs, title)
        taskViewModel.addDataToAPI(AddTaskReqData(task = task, userId = USER_ID))
    }

}