package com.rcl.nextshiki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rcl.nextshiki.navigation.screens.MainScreen
import com.rcl.nextshiki.navigation.screens.ProfileScreen
import com.rcl.nextshiki.navigation.screens.SearchScreen
import com.rcl.nextshiki.user.Auth

class NavClass{
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = Routes.MainScreen.routes) {
            composable(Routes.MainScreen.routes) {
                MainScreen().Screen()
            }
            composable(Routes.SearchScreen.routes) {
                SearchScreen().Screen()
            }
            composable(Routes.ProfileScreen.routes) {
                ProfileScreen().Screen(navController)
            }
            composable(Routes.LoginScreen.routes) {
                Auth().AuthInApp(navController = navController)
            }
        }
    }
    companion object NavItemsList {
        val itemList = listOf(
            BottomNavItem.Main,
            BottomNavItem.Search,
            BottomNavItem.Profile,
        )
    }
}