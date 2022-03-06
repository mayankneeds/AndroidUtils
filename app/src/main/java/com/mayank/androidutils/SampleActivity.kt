package com.mayank.androidutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            repository.insertUser(User(firstName = "Mayank", lastName = "Sharma"))

            launch(Dispatchers.Main) {
                Toast.makeText(applicationContext, repository.getAllUsers().toString(), Toast.LENGTH_LONG).show()
            }
        }

    }
}