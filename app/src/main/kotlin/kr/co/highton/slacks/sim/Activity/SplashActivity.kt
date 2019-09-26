package kr.co.highton.slacks.sim.Activity


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kr.co.highton.slacks.sim.R


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}