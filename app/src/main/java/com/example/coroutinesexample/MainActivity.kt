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

        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5) {
                Log.d(TAG, "Starting long running calculation...")
                withTimeout(3000L) {
                    for (i in 30..40) {
                        if (isActive) {
                            Log.d(TAG, "Result for i = $i: ${fib(i)}")
                        }
                    }
                }
                Log.d(TAG, "Ending long running calculation...")
            }
        }
    }

    private fun fib(n: Int): Long {
        return when (n) {
            0 -> 0
            1 -> 1
            else -> fib(n - 1) + fib(n - 2)
        }
    }

}