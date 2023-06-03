package com.rcl.nextshiki.navigation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.rcl.nextshiki.user.User
import com.rcl.uikit.Blocks

class ProfileScreen {
    @Composable
    fun Screen(navController: NavController){
        Blocks().ProfileScreen(
            userData = User.CurrUser,
            navController = navController,
            isCurrentUser = true
        )
    }
}