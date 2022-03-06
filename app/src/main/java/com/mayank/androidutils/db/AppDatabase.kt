package com.mayank.androidutils.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun userDao(): UserDao


    companion object {
        private const val mRoomDbName = "your.room.db.name"

        @Volatile
        private var mInstance: AppDatabase? = null

        fun getInstance(context:Context) = mInstance ?:  synchronized(this) {
            val newInstance = mInstance ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, mRoomDbName).build().also { mInstance = it }
            newInstance
        }
    }
}