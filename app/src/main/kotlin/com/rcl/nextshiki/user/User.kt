package com.rcl.nextshiki.user

import com.rcl.nextshiki.retrofit.usermodel.UserData

object User {
    const val sharedPrefName = "SherPref"
    const val tokprf = "token"
    lateinit var CurrUser: UserData
}