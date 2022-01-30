package com.mamang.marketplace.core.data.source.remote.network


import com.mamang.marketplace.core.data.source.remote.request.LoginRequest
import com.mamang.marketplace.core.data.source.remote.response.LoginResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
    ): Response<LoginResponse>

    @POST("register")
    suspend fun register(
//        @Body login: LoginRequest,
    ): Response<RequestBody>
}