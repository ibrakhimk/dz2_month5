package com.example.dz2_month5.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getPercentage(firstname: String,secondName: String):MutableLiveData<LoveModel>{
        val mutableLiveData = MutableLiveData<LoveModel>()
        LoveService().api.getPercentage(firstname,secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    mutableLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.d("ololo", "onFailure: ${t.message}")
            }

        })
        return mutableLiveData
    }

}