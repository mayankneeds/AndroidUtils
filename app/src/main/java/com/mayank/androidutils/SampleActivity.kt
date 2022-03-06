package com.mayank.androidutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.mayank.androidutils.db.AppDatabase
import com.mayank.androidutils.db.Repository
import com.mayank.androidutils.db.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SampleActivity : AppCompatActivity() {

    private val viewModel:SampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)


        viewModel.insertUser(User(firstName = "Mayank", lastName = "Sharma"))

        viewModel.allUsersLiveData.observe(this){
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
        }

        viewModel.getAllUsers()
    }
}