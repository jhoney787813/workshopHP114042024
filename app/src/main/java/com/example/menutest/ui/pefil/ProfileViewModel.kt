package com.example.menutest.ui.pefil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ESTAMOS EN PROFILE por fragmento"
    }
    val text: LiveData<String> = _text
}