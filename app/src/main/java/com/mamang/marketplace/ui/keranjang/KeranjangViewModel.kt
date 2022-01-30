package com.mamang.marketplace.ui.keranjang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KeranjangViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Keranjang Fragmen"
    }
    val text: LiveData<String> = _text
}