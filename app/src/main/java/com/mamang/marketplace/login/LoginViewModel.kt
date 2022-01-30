package com.mamang.marketplace.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mamang.marketplace.core.data.repository.AppRepository
import com.mamang.marketplace.core.data.source.remote.request.LoginRequest

class LoginViewModel(val repo:AppRepository):ViewModel() {
    fun login(data:LoginRequest) = repo.login(data).asLiveData()
}