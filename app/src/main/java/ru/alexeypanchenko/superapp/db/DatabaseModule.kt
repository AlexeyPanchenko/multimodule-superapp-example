package ru.alexeypanchenko.superapp.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.alexeypanchenko.donorapp.db.AppDatabase
import ru.alexeypanchenko.donorapp.db.ItemDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "items.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun getItemsDao(database: AppDatabase): ItemDao {
        return database.itemDao()
    }

}