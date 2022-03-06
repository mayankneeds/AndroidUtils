package com.mayank.androidutils.db

class Repository(private val userDao: UserDao) {

    suspend fun insertUser(user: User) = userDao.insertAll(user)

    suspend fun getAllUsers() = userDao.getAll()

}