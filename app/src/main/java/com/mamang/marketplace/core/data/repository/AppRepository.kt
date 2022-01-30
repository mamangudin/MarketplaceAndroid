package com.mamang.marketplace.core.data.repository



import com.inyongtisto.myhelper.extension.getErrorBody
import com.inyongtisto.myhelper.extension.logs
import com.mamang.marketplace.core.data.source.local.LocalDataSource
import com.mamang.marketplace.core.data.source.remote.RemoteDataSource
import com.mamang.marketplace.core.data.source.remote.network.Resource
import com.mamang.marketplace.core.data.source.remote.request.LoginRequest
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AppRepository(val local:LocalDataSource, val remote:RemoteDataSource) {
    fun login(data: LoginRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.login(data).let {
                if(it.isSuccessful){
                    val body = it.body()
                    emit(Resource.success(body?.data))
                    logs("succes:" + body.toString())
                }else{
                    emit(Resource.error(it.getErrorBody()?.message ?: "Default error dongs", null))
                    logs("Error:" + "keteragan error")
                }
            }
        } catch (e: Exception){
            emit(Resource.error(e.message?:"terjadi kesalahan",null))
            logs("Error:" + e.message)
        }
    }

}