package dev.amol.frndassignment.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.amol.frndassignment.model.local.TaskDAO
import dev.amol.frndassignment.model.local.TaskRoomDataBase
import dev.amol.frndassignment.model.remote.apiservice.APIService
import dev.amol.frndassignment.utils.Utility.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TaskModule {


    // Provider for API Client Instance
    @Singleton
    @Provides
    fun provideAPIService(): APIService {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return builder.create(APIService::class.java)
    }

    // Provider for RoomDatabase
    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): TaskRoomDataBase {
        val builder = Room.databaseBuilder(
            context.applicationContext,
            TaskRoomDataBase::class.java,
            "task_db"
        )
        builder.fallbackToDestructiveMigration()
        return builder.build()
    }

    // Provider for taskdao
    @Singleton
    @Provides
    fun provideTaskDao(db: TaskRoomDataBase): TaskDAO {
        return db.getTaskDAO()
    }
}