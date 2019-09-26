package kr.co.highton.slacks.sim.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.util.Xml
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.highton.slacks.sim.Fragment.BeautyWebviewFragment
import kr.co.highton.slacks.sim.Fragment.ChatWebViewFragment
import kr.co.highton.slacks.sim.Fragment.SettingWebViewFragment
import kr.co.highton.slacks.sim.Fragment.WriteWebViewFragment
import kr.co.highton.slacks.sim.R
import java.net.URLEncoder

class MainActivity : BaseActivity() {

    private var mwv: WebView? = null//Mobile Web View
    override var viewId: Int = R.layout.activity_main
    override var toolbarId: Int? = R.id.toolbar
    private lateinit var toast: Toast
    private var backKeyPressedTime: Long = 200
    private var mViewPager: ViewPager? = null

    @SuppressLint("ShowToast")
    override fun onCreate() {
        mwv = findViewById(R.id.WebView) as WebView
        val mws = mwv!!.settings//Mobile Web Setting
//        var str = "email=" + URLEncoder.encode("shimhg02@naver.com", "UTF-8") + "&member_srl=" + URLEncoder.encode("69", "UTF-8")
        mws.javaScriptEnabled = true//자바스크립트 허용
        mws.loadWithOverviewMode = true//컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        logo.setOnClickListener {
           startActivity(Intent(this@MainActivity, DesignActivity::class.java))
        }
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, WriteActivity::class.java))
        }
        mwv!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
//        System.out.println("(LOGD) : "+str.toByteArray())
        mwv!!.loadUrl("https://creator.hoto.dev/open_board.php?email=shimhg02@naver.com&member_srl=69")
    }
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