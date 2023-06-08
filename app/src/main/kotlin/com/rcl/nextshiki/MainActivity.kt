package com.rcl.nextshiki

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rcl.nextshiki.navigation.NavClass
import com.rcl.nextshiki.user.HiltVM
import com.rcl.nextshiki.user.User.isAuthorized
import com.rcl.nextshiki.user.User.vm
import com.rcl.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Theme().NextShikiTheme {
                navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    vm = hiltViewModel<HiltVM>()
                    if (vm.getStringPref("authCode") != null) {
                        isAuthorized = true
                        vm.upgradeToken()
                    }
                    NavBar()
                }
            }
        }
        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent: Intent = intent
        val appLinkAction: String? = appLinkIntent.action
        val appLinkData: Uri? = appLinkIntent.data
        if (appLinkData != null) {
            val appLinkRealData = appLinkData.toString().split("/")[3]
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun NavBar() {
        val backStackEntry = navController.currentBackStackEntryAsState()
        Box(
            modifier = Modifier.padding(
                top = WindowInsets.systemBars.asPaddingValues().calculateTopPadding() + 10.dp
            )
        ) {
            Scaffold(
                bottomBar = {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.background
                    ) {
                        NavClass.itemList.forEach { item ->
                            val selected = item.route == backStackEntry.value?.destination?.route
                            NavigationBarItem(
                                selected = selected,
                                onClick = { navController.navigate(item.route) },
                                label = {
                                    Text(
                                        text = item.title,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) {
                                            item.filledIcon
                                        } else {
                                            item.icon
                                        },
                                        contentDescription = "${item.title} Icon",
                                    )
                                }
                            )
                        }
                    }
                },
                content = {
                    NavClass().Navigation(navController = navController)
                }
            )
        }
    }
}