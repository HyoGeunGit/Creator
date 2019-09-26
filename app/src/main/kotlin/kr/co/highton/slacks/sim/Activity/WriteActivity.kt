package kr.co.highton.slacks.sim.Activity


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kr.co.highton.slacks.sim.R

class WriteActivity : AppCompatActivity() {
    private var mwv: WebView? = null//Mobile Web View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        mwv = findViewById(R.id.webView) as WebView
        val mws = mwv!!.settings//Mobile Web Setting
        mws.javaScriptEnabled = true//자바스크립트 허용
        mws.loadWithOverviewMode = true//컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        mwv!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        mwv!!.loadUrl("https://github.com/HyoGeunGit")
    }
    //   추가전에 뒤로가기 이벤트 호출시 홈으로 돌아갔으나, 이젠 일반적인 뒤로가기 기능 활성화
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mwv!!.canGoBack()) {
                mwv!!.goBack()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}