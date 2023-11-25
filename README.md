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



Dependency used:

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.0'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.2'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    //Room
    implementation 'androidx.room:room-ktx:2.3.0'
    kapt 'androidx.room:room-compiler:2.3.0'

    // MVvP
    // ViewModel and LiveData
    def arch_version = '2.2.0-alpha01'
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    //ViewModels delegation extentensions for activity
    implementation 'androidx.activity:activity-ktx:1.3.1'


    //Retrofit
    def retrofit2_version = "2.9.0"
    def okhttp3_version = "4.9.0"
    //retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"

    //Okhttp3
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"


    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    //mockito
    androidTestImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "org.mockito:mockito-core:2.27.0"
    testImplementation "android.arch.core:core-testing:2.1.0"
    testImplementation "com.squareup.okhttp:mockwebserver:3.6.0"

    //glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    kapt 'com.github.bumptech.glide:compiler:4.12.0'

