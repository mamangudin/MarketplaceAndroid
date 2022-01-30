package com.mamang.marketplace.core.data.source.remote


import com.mamang.marketplace.core.data.source.remote.network.ApiService
import com.mamang.marketplace.core.data.source.remote.request.LoginRequest

class RemoteDataSource(val api:ApiService) {
    suspend fun login(data: LoginRequest) = api.login(data)
}