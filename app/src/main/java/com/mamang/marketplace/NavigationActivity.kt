package com.mamang.marketplace

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mamang.marketplace.databinding.ActivityNavigationBinding
import com.mamang.marketplace.login.LoginActivity
import com.mamang.marketplace.until.Prefs

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_keranjang
            )
        )

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

            if(it.itemId == R.id.navigation_notifications){
                val s = Prefs(this)
                if(s.getIsLogin()){
                    Log.d("TAG","Sudah Aktif")
                    navController.navigate(it.itemId)
                }else{
                    Log.d("TAG","Tidak Aktif")
                    startActivity(Intent(this,LoginActivity::class.java))
                }
                Log.d("TAG","onCreated:  notif")
            }else{
                navController.navigate(it.itemId)
                Log.d("TAG","onCreated:  yang lain" + it.itemId)
            }

            return@setOnItemSelectedListener true
        }
    }
}