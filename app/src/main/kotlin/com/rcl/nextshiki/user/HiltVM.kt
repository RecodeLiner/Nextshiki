package com.rcl.nextshiki.user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rcl.models.usermodel.UserData
import com.rcl.nextshiki.retrofit.ApiRepository
import com.rcl.preferences.SharedPreferencesHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HiltVM @Inject constructor(private val repository: ApiRepository, private val sharedPreferencesHelper: SharedPreferencesHelper): ViewModel() {
    fun getUser(id: String, isNickname: Boolean) : UserData? {
        var user: UserData? = null
        viewModelScope.launch {
            repository.getUser(id = id, isNickname = isNickname).let {
                if (it.isSuccessful) {
                    Log.d("Success", "Success ${it.body()}")
                    user = it.body()!!
                }
                else {
                    Log.d("Error", "Failed ${it.errorBody()}")
                }
            }
        }
        return user
    }

    fun getCurrentUser(){
        viewModelScope.launch {
            repository.getCurrentUser().let {
                if (it.isSuccessful) {
                    setPref("userId", it.body()!!.id.toString())
                }
                else {
                    Log.d("Error", "Failed ${it.errorBody()}")
                }
            }
        }
    }
    fun upgradeToken(){
        viewModelScope.launch {
            val refreshToken = getStringPref("refreshToken")!!
            repository.upgradeToken(refreshToken = refreshToken).let {
                if (it.isSuccessful) {
                    setPref("refreshToken", it.body()!!.refresh_token)
                    repository.setToken(it.body()!!.access_token)
                }
                else {
                    Log.d("Error", "Failed ${it.errorBody()}")
                }
            }
        }
    }

    fun getToken(){
        viewModelScope.launch {
            val code = getStringPref("authCode")!!
            repository.getToken(code).let {
                if (it.isSuccessful) {
                    repository.setToken(it.body()!!.access_token)
                    setPref("refreshToken", it.body()!!.refresh_token)
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

    fun getStringPref(key: String, defaultValue: String? = null): String? { return sharedPreferencesHelper.getString(key, defaultValue) }

    fun setPref(key: String, value: String) { sharedPreferencesHelper.setString(key, value) }
}