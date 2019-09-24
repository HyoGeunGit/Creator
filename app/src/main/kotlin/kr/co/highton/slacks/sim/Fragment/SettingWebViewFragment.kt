package kr.co.highton.slacks.sim.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kr.co.highton.slacks.sim.R

@Suppress("UNREACHABLE_CODE")
class SettingWebViewFragment:Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_beauty, container, false)
//        val mWebView = v.findViewById(R.id.webViewT1) as WebView
//        mWebView.loadUrl("https://www.google.com")
//        // Enable Javascript
//        val webSettings = mWebView.getSettings()
//        webSettings.setJavaScriptEnabled(true)
//        // Force links and redirects to open in the WebView instead of in a browser
//        mWebView.setWebViewClient(WebViewClient())
//        return v
    }
}