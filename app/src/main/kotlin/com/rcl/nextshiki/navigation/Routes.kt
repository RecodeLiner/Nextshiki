package com.rcl.nextshiki.navigation

sealed class Routes(val routes: String) {
    object MainScreen : Routes("MainScreen")
    object SearchScreen : Routes("SearchScreen")
    object ProfileScreen : Routes("ProfileScreen")
}