package com.example.dz2_month5

import android.content.Context

class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun isUserSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    companion object {
        const val PREF_NAME = "pref.task"
        const val SEEN_KEY = "seen.key"
    }
}