package com.example.menutest.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhotoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ESTAMOS EN PHOTOS por fragmento"
    }
    val text: LiveData<String> = _text
}