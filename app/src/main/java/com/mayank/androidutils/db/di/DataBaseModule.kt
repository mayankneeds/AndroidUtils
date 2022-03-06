package com.mayank.androidutils.db.di

import android.content.Context
import androidx.room.Room
import com.mayank.androidutils.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext, AppDatabase::class.java,
        AppDatabase.mRoomDbName
    ).build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase) = appDatabase.userDao()
}