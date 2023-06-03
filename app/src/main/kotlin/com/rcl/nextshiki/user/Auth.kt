package com.rcl.nextshiki.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rcl.nextshiki.MainActivity


class Auth {
    @Composable
    fun AuthInApp(vm: HiltVM) {
        Box(modifier = Modifier.padding(top = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()+10.dp)){
            val clientId = "cMHJgY_yAUOWvAR8Pfrumtf9XZSmg56Y2E55sZM1zaA"
            val redirectUri = "urn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob"
            val responseType = "code"
            val scope = "user_rates+messages+comments+topics+clubs+friends"
            AuthView().AuthWebView(
                initialUrl = "https://shikimori.me/oauth/authorize?client_id=${clientId}&redirect_uri=${redirectUri}&response_type=${responseType}&scope=${scope}",
                onAuthUrlChange = { url ->
                    if (url.contains("https://shikimori.me/oauth/authorize") && !url.split("authorize")[1].contains("?client_id")) {
                        vm.setPref("AuthCode", url.split("authorize/")[1])
                        MainActivity().recreate();
                    }
                }
            )
        }
    }
}