package com.rcl.nextshiki.user

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.viewinterop.AndroidView

class AuthView {
    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun AuthWebView(
        initialUrl: String,
        onAuthUrlChange: (String) -> Unit
    ) {
        val currentUrl by remember { mutableStateOf(initialUrl) }

        AndroidView(factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        onAuthUrlChange(url ?: "")
                    }
                }
                loadUrl(initialUrl)
            }
        }, update = { view ->
            view.loadUrl(currentUrl)
        })
    }
}
