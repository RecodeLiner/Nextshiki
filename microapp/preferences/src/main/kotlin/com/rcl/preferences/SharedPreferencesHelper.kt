package com.rcl.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun setInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getDouble(key: String, defaultValue: Double): Double {
        return sharedPreferences.getString(key, defaultValue.toString())?.toDouble() ?: defaultValue
    }

    fun setDouble(key: String, value: Double) {
        sharedPreferences.edit().putString(key, value.toString()).apply()
    }

    fun getString(key: String, defaultValue: String? = null): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun setString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }
}

