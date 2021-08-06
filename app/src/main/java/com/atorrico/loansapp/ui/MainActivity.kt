package com.atorrico.loansapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.atorrico.loansapp.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.root, LoanFragment())
            .commitAllowingStateLoss()
    }
}