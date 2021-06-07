package com.example.santanu.databindingdemo.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainActivityViewModel(initCount: Int) : ViewModel() {
    private lateinit var count: MutableLiveData<Int>
    val totalCount: LiveData<Int>
    get() = count
    init {
        count = MutableLiveData(initCount)
    }

    fun add() {
        count.value = count.value?.plus(1)
    }

    class MainActivityViewModelFactory(private var initCount: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
                return MainActivityViewModel(initCount) as T
            }
            throw IllegalArgumentException("IllegalArgument")
        }
    }
}