package com.example.pharmandroid.Utils

import com.example.pharmandroid.Utils.Models.User
import com.example.pharmandroid.Utils.Models.authResponse
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException


interface WebInterface {

    @GET("/users")
    fun getUser(): Observable<User>

    @GET("/users/one/devices")
    fun getDevice(): Observable<User>

    @GET("/register")
    fun register(): Observable<authResponse>

    @GET("/login")
    fun login(): Observable<authResponse>

    companion object {
        private val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", authResponse.key)
                    .build()
                return chain.proceed(newRequest)
            }
        }).build()

        fun create(): WebInterface {
            val retrofit: Retrofit = Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                )
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .baseUrl("http://127.0.0.1:3000/")
                .build()

            return retrofit.create(WebInterface::class.java)
        }
    }
}