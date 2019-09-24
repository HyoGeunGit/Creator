package kr.co.highton.slacks.sim.Retrofit

import kr.co.highton.slacks.sim.API.API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



object Client {
    var retrofitService: API
    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val logger = OkHttpClient.Builder().addInterceptor(interceptor).
                addInterceptor { chain->
                    val request = chain.request().newBuilder()
                            .addHeader("Accesstype", "nowtesting123")
                            .build()
                    chain.proceed(request) }.readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build()


        val retrofit = Retrofit.Builder()
                .baseUrl("https://prj.hoto.dev")
                .addConverterFactory(GsonConverterFactory.create())
                .client(logger)
                .build()

        retrofitService = retrofit.create(API::class.java)


    }
}

//