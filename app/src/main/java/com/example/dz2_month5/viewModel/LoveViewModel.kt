package com.example.dz2_month5.viewModel

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dz2_month5.remote.LoveModel
import com.example.dz2_month5.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository, val preferences: SharedPreferences) : ViewModel() {


//
//    fun getLiveLoveModel(firstname: String, secondName:String): LiveData<LoveModel>{
//        return repository.getPercentage(firstname,secondName)
//    }



        fun getLiveLoveModel(firstname:String, secondName:String): LiveData<LoveModel> {
            return repository.getPercentage(firstname, secondName)
        }

        fun isUserSeen() : Boolean{
            return preferences.getBoolean(USER_SEEN_KEY, false)
        }

        @SuppressLint("CommitPrefEdits")
        fun userSeen() {
            preferences.edit().putBoolean(USER_SEEN_KEY, true).apply()
        }

        companion object {
            const val USER_SEEN_KEY = "USER_SEEN_KEY"
        }
}