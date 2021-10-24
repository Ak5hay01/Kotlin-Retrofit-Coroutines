package com.akshayteli.retrofitcoroutinekotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit.RetrofitInstance
import retrofit.RetrofitService

/**
 * Created by Akshay Teli on 28,May,2021
 */
class MainActivityViewModel:ViewModel() {

    var imageData : MutableLiveData<Bitmap> = MutableLiveData()

    fun getImageObserver(): MutableLiveData<Bitmap>{
        return imageData
    }

    fun makeApiCall(){
//        Coroutine scope is used, so when the viewModel is destroyed the scope is also destroyed
        viewModelScope.launch(Dispatchers.IO) {
            val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
            val response = retrofitInstance.getImage()
            val bytes = response.bytes()
            val bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.size)
            imageData.postValue(bitmap)
        }
    }
}