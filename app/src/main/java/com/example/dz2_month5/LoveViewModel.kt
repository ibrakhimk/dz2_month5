package com.example.dz2_month5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dz2_month5.remote.LoveModel
import com.example.dz2_month5.remote.Repository

class LoveViewModel : ViewModel() {

    val repository = Repository()

    fun getLiveLoveModel(firstname: String, secondName:String): LiveData<LoveModel>{
        return repository.getPercentage(firstname,secondName)
    }
}