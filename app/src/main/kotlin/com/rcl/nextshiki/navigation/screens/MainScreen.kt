package com.rcl.nextshiki.navigation.screens

import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.rcl.nextshiki.user.HiltVM

class MainScreen {
    @Composable
    fun Screen(viewModel: HiltVM) {
        Button(onClick = { viewModel.getUser("RCLucker", true) }) {
            Text("Get User")
        }
    }
}