package com.akshayteli.retrofitcoroutinekotlin

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        on click listener for button
        navigate_btn.setOnClickListener(this)

//        set downloaded image to imageview
        setImage()
    }

    //Fetch image from network using retrofit
    private fun setImage(){

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getImageObserver().observe(this, Observer<Bitmap> {
            imgView.setImageBitmap(it)
        })

        //        Calling the viewModel to fetch data from network
        viewModel.makeApiCall()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
           R.id.navigate_btn -> {
               //Toast.makeText(this, "Navigation Button clicked", Toast.LENGTH_LONG).show()

               //send data from one activity to another
               val intent  =  Intent(this@MainActivity,SecondActivity::class.java)
               intent.putExtra("string","I am Happy")
               startActivity(intent)

           }
        }
    }


}