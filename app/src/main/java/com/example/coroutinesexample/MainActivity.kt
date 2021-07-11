package com.example.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var tvDummy: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Before runBlocking")

//        runBlocking affects the Main Thread.
        runBlocking {

//        this launch code runs asynchronously.
            launch {
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 1")
            }

            launch {
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 2")
            }

            Log.d(TAG, "Start of runBlocking")
            delay(5000L)
            Log.d(TAG, "End of runBlocking")
        }

        Log.d(TAG, "After runBlocking")
    }

}