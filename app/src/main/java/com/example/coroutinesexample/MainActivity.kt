package com.example.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity()
{
    private val TAG = "MainActivity"
    private lateinit var tvDummy : TextView
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvDummy = findViewById(R.id.tv_dummy)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG , "Starting coroutine in thread ${Thread.currentThread().name}")
            val result = doNetworkCalls()
            withContext(Dispatchers.Main) {
                Log.d(TAG , "Setting text in thread ${Thread.currentThread().name}")
                tvDummy.text = result
            }
        }

    }

    private suspend fun doNetworkCalls() : String
    {
        delay(3000L)
        return "This is the response from first resource"
    }

}