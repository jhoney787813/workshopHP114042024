package com.example.menutest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "hola mensaje personalizado por fragmento"
    }
    val text: LiveData<String> = _text
}