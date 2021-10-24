package com.akshayteli.retrofitcoroutinekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message:String = intent!!.getStringExtra("string").toString()

        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}