package com.mayank.androidutils.db

import javax.inject.Inject

class Repository @Inject constructor (private val userDao: UserDao) {

    suspend fun insertUser(user: User) = userDao.insertAll(user)

    suspend fun getAllUsers() = userDao.getAll()

}