package com.mayank.androidutils

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mayank.androidutils.common.network.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SampleActivity : AppCompatActivity() {


    private val viewModel: SampleViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        viewModel.quotesLiveData.observe(this) {
            val msg = when (it.status) {
                Resource.Status.SUCCESS -> it.data.toString()
                Resource.Status.LOADING -> "loading"
                Resource.Status.ERROR -> it.message
            }
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }

        viewModel.getQuotes()
    }
}