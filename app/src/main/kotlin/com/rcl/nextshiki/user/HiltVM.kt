package com.rcl.nextshiki.user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rcl.nextshiki.retrofit.ApiRepository
import com.rcl.preferences.SharedPreferencesHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HiltVM @Inject constructor(private val repository: ApiRepository, private val sharedPreferencesHelper: SharedPreferencesHelper): ViewModel() {

    fun getUser(id: String, isNickname: Boolean) {
        viewModelScope.launch {
            repository.getUser(id = id, isNickname = isNickname).let {
                if (it.isSuccessful) {
                    User.CurrUser = it.body()!!
                    Log.d("Success", "Success ${it.body()}")
                }
                else {
                    Log.d("Error", "Failed ${it.errorBody()}")
                }
            }
        }
    }

    fun getListOf(userId: String, isAnime: Boolean) {
        viewModelScope.launch {
            repository.getListOf(userId = userId, isAnime = isAnime).let {
                if (it.isSuccessful){
                    it.body()!!
                }
                else {
                    Log.d("Error", "Failed ${it.errorBody()}")
                }
            }
        }
    }

    fun getStringPref(key: String, defaultValue: String? = null): String? {
        return sharedPreferencesHelper.getString(key, defaultValue)
    }

    fun setPref(key: String, value: String){
        sharedPreferencesHelper.setString(key, value)
    }
}