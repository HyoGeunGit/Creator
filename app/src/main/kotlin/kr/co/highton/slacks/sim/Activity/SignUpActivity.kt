package kr.co.highton.slacks.sim.Activity

import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_signup.id_tv
import kotlinx.android.synthetic.main.activity_signup.pw_tv
import kr.co.highton.slacks.sim.R
import kr.co.highton.slacks.sim.Repo.SIgnUpRepo
import kr.co.highton.slacks.sim.Retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : BaseActivity() {

    override var viewId: Int = R.layout.activity_signup
    override var toolbarId: Int? = R.id.toolbar
    override fun onCreate() {
        findViewById<Button>(R.id.sign_btn).setOnClickListener {
            Client.retrofitService.logUp(name_tv.text.toString(), id_tv.text.toString(), ph_tv.text.toString(), pw_tv.text.toString()).enqueue(object : Callback<SIgnUpRepo> {
                override fun onResponse(call: Call<SIgnUpRepo>?, response: Response<SIgnUpRepo>?) {
                    when (response!!.code()) {
                        200 -> {
                            when {
                                response!!.body()!!.status.toInt() == 200 -> {
                                    Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_LONG).show()
                                    finish ()
                                }
                                response!!.body()!!.status.toInt() == 401 -> Toast.makeText(this@SignUpActivity, "회원가입 실패 : 중복된 유저입니다", Toast.LENGTH_LONG).show()
                            }
//                            when (response!!.body()!!.status) {
////                                200 -> {
////                                    Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_LONG).show()
////                                    finish ()
////                                }
////                                401 -> Toast.makeText(this@SignUpActivity, "회원가입 실패 : 중복된 유저입니다", Toast.LENGTH_LONG).show()
////                                500 -> Toast.makeText(this@SignUpActivity, "회원가입 실패 : 서버 오류", Toast.LENGTH_LONG).show()
//                            }
                        }
                    }
                }

                override fun onFailure(call: Call<SIgnUpRepo>?, t: Throwable?) {

                }


            })
        }
    }

}