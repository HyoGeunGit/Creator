package kr.co.highton.slacks.sim.API

import kr.co.highton.slacks.sim.Repo.LoginRepo
import kr.co.highton.slacks.sim.Repo.SIgnUpRepo
import retrofit2.Call
import retrofit2.http.*

interface API {

    @POST("/login.php")
    @FormUrlEncoded
    fun logIn(@Field("id") id : String, @Field("pw") pw : String) :  Call<LoginRepo>

    @POST("/signup.php")
    @FormUrlEncoded
    fun logUp(@Field("name") name : String, @Field("email") email : String,  @Field("phone") phoneNum : String, @Field("pw") pw : String) :  Call<SIgnUpRepo>

}