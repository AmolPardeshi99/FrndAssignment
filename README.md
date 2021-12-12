# FrndAssignment

Task:

In this task, you will have to make a calendar application with the following features.

Select Year and Month
Based on the selected year and month show the month view(as attached in photo below). Please make the month view by yourself. Don't use any library or any predefined calendar views.
Select any date from the month view and add a task to it. Whenever you add a task(it needs to be synced with the backend via api call). Details of APIs are given below.
A separate place in the app where you fetch the task list from the backend and show it in the recycler view. This view should contain details about each task.
Option to delete the task on selecting a particular task.

Following are bonus features if your time and speed permit:

Scroll the month calendar view left and right to move to previous/next month.
Everytime you fetch the task list from backend you store it in local Room database as well. So that, if internet is not working, you can fetch tasks from the local database.
Show the number of tasks for a particular day in the calendar view.


You need to use MVVM architecture. Dagger and RxJava is a plus(not compulsory). You have to design the api(not write the backend) by yourself(basically what should be request and response parameters)




Month View: This is just a reference month view. No need to make the exact same design. This is here just for reference





API Details

Postman Collection: https://drive.google.com/file/d/1nRkugsJbKP1JhYfir3D0wvvmXZyQgvnW/view?usp=sharing

Base url : http://13.232.92.136:8084/

StoreCalendarTask: /api/storeCalendarTask   [POST]

Request Parameters:
user_id: int
task: TaskModel

      2.   GetCalendarTaskList: /api/getCalendarTaskLists   [POST]

	Request Parameters:
user_id: int
            Response:
task_details: List<task_id, TaskModel>

       3. Delete CalendarTask: /api/deleteCalendarTask   [POST]

	Request Parameters:
user_id: int
task_id: int


user_id to be used:

