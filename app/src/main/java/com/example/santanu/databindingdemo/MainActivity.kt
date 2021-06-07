package com.example.santanu.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.santanu.databindingdemo.databinding.ActivityMainBinding
import com.example.santanu.databindingdemo.modules.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val INIT_VALUE: Int = 10
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var mainActivityVewModelFactory = MainActivityViewModel.MainActivityViewModelFactory(INIT_VALUE)
        mViewModel = ViewModelProvider(this, mainActivityVewModelFactory).get(MainActivityViewModel::class.java)
        mBinding.mViewModel = mViewModel
        mBinding.lifecycleOwner = this
    }
}