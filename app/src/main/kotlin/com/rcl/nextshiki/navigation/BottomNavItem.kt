package com.rcl.nextshiki.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title:String, var icon: ImageVector, val filledIcon: ImageVector, var route:String){
    object Main : BottomNavItem(
        "Main",
        Icons.Outlined.Home,
        Icons.Filled.Home,
        "MainScreen")
    object Search : BottomNavItem(
        "Search",
        Icons.Outlined.Search,
        Icons.Filled.Search,
        "SearchScreen")
    object Profile : BottomNavItem(
        "Profile",
        Icons.Outlined.AccountCircle,
        Icons.Filled.AccountCircle,
        "ProfileScreen")
}
