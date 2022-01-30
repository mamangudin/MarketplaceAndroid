package com.mamang.marketplace.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.myhelper.extension.*
import com.inyongtisto.myhelper.extension.showToast
import com.mamang.marketplace.R
import com.mamang.marketplace.core.data.source.remote.network.State
import com.mamang.marketplace.core.data.source.remote.request.LoginRequest
import com.mamang.marketplace.databinding.ActivityLoginBinding
import com.mamang.marketplace.databinding.FragmentDashboardBinding
import com.mamang.marketplace.until.Prefs
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel : LoginViewModel by viewModel()
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainButton()


    }

    private fun mainButton() {
        binding.btnMasuk.setOnClickListener {
           login()
        }
    }

    private fun login() {
        if (binding.edtEmail.isEmpty()) return
        if (binding.edtPassword.isEmpty()) return
        val body = LoginRequest(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        )
        viewModel.login(body).observe(this,{
            when(it.state){
                State.SUCCESS -> {
                    dismisLoading()
                    showToast("Selamat datang " + it.data?.name)
                }
                State.ERROR -> {
                    dismisLoading()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    showLoading()
                }
            }
        })
    }
}