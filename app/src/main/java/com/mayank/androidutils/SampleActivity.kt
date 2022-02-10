package com.mayank.androidutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mayank.androidutils.utils.ConnectionLiveData

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val connectionLiveData=ConnectionLiveData(applicationContext)
        connectionLiveData.observe(this){ isAvailable ->
            Toast.makeText(applicationContext,"Network Available: $isAvailable",Toast.LENGTH_LONG).show()
        }

    }
}