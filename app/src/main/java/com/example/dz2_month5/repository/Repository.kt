package com.example.dz2_month5.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dz2_month5.remote.LoveApi
import com.example.dz2_month5.remote.LoveModel
import com.example.dz2_month5.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {

    fun getPercentage(firstname: String,secondName: String):MutableLiveData<LoveModel>{
        val mutableLiveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstname,secondName).enqueue(object : Callback<LoveModel>{
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