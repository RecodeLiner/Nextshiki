package com.rcl.nextshiki.navigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.rcl.nextshiki.navigation.Routes
import com.rcl.nextshiki.user.User
import com.rcl.nextshiki.user.User.vm
import com.rcl.uikit.R

class ProfileScreen {
    @Composable
    fun Screen(navController: NavController){
        if (!User.isAuthorized){
            Column {
                Text(text = LocalContext.current.getString(R.string.not_logged_in))
                Button(onClick = { navController.navigate(Routes.LoginScreen.routes) }) {
                    Text(text = LocalContext.current.getString(R.string.login))
                }
            }
        }
        else{
            val id = vm.getStringPref("userId")!!
            val user = vm.getUser(id, false)

        }
    }
}