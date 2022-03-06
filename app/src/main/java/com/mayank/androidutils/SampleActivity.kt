package com.mayank.androidutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.mayank.androidutils.db.AppDatabase
import com.mayank.androidutils.db.Repository
import com.mayank.androidutils.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val repository = Repository(AppDatabase.getInstance(this).userDao())

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                repository.insertUser(User(firstName = "Mayank", lastName = "Sharma"))
                val users = repository.getAllUsers().toString()

                launch(Dispatchers.Main) {
                    Toast.makeText(applicationContext, users, Toast.LENGTH_LONG).show()
                }
            } catch (e: Throwable) {
                Log.e("SampleActivity", e.toString())
            }
        }

    }
}