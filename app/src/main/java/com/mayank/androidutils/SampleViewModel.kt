package com.mayank.androidutils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayank.androidutils.db.Repository
import com.mayank.androidutils.db.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _allUsersLiveData = MutableLiveData<List<User>>()
    val allUsersLiveData get() = _allUsersLiveData

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        try {
            repository.insertUser(user)
        } catch (e: Throwable) {
            Log.e("SampleViewModel", e.toString())
        }
    }

    fun getAllUsers() = viewModelScope.launch(Dispatchers.IO) {
        _allUsersLiveData.postValue(repository.getAllUsers())
    }

}