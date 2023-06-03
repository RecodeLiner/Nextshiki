package com.rcl.nextshiki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rcl.nextshiki.navigation.screens.MainScreen
import com.rcl.nextshiki.navigation.screens.ProfileScreen
import com.rcl.nextshiki.navigation.screens.SearchScreen
import com.rcl.nextshiki.user.HiltVM

class NavClass{
    @Composable
    fun Navigation(navController: NavHostController, viewModel: HiltVM) {
        NavHost(navController = navController, startDestination = Routes.MainScreen.routes) {
            composable(Routes.MainScreen.routes) {
                MainScreen().Screen(viewModel = viewModel)
            }
            composable(Routes.SearchScreen.routes) {
                SearchScreen().Screen()
            }
            composable(Routes.ProfileScreen.routes) {
                ProfileScreen().Screen(navController)
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