package com.example.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()
{
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val networkCallResponse1 = doNetworkCalls1()
            Log.d(TAG , "Network Call Response 1: $networkCallResponse1")
            val networkCallResponse2 = doNetworkCalls2()
            Log.d(TAG , "Network Call Response 2: $networkCallResponse2")
        }
    }

    suspend fun doNetworkCalls1() : String
    {
        delay(3000L)
        return "This is the response from first resource"
    }

    suspend fun doNetworkCalls2() : String
    {
        delay(3000L)
        return "This is the response from 2nd resource"
    }
}