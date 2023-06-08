package com.rcl.nextshiki.user

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.rcl.nextshiki.user.User.vm


class Auth {
    @Composable
    fun AuthInApp(navController: NavHostController) {
        val clientId = "cMHJgY_yAUOWvAR8Pfrumtf9XZSmg56Y2E55sZM1zaA"
        val redirectUri = "urn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob"
        val responseType = "code"
        val scope = "user_rates+messages+comments+topics+clubs+friends"
        AuthView().AuthWebView(
            initialUrl = "https://shikimori.me/oauth/authorize?client_id=${clientId}&redirect_uri=${redirectUri}&response_type=${responseType}&scope=${scope}",
            onAuthUrlChange = { url ->
                if (url.contains("https://shikimori.me/oauth/authorize") && !url.split("authorize")[1].contains("?client_id")) {
                    vm.setPref("authCode", url.split("authorize/")[1])
                    navController.popBackStack()
                    User.isAuthorized = true
                    vm.getToken()
                }
            }
        )
    }
}