package com.example.dz2_month5.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dz2_month5.remote.LoveModel
import com.example.dz2_month5.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {



    fun getLiveLoveModel(firstname: String, secondName:String): LiveData<LoveModel>{
        return repository.getPercentage(firstname,secondName)
    }
}