package com.mayank.androidutils.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val mRoomDbName = "your.room.db.name"
    }

    abstract fun userDao(): UserDao


}