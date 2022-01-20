package com.example.test6.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test6.common.common
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivitiViewModel: ViewModel() {

    private val _urlList = MutableLiveData<List<String>>()
    val urlList: LiveData<List<String>>
        get() = _urlList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _urlList.postValue(common.Common.retrofitService.getUrlList())
        }
    }
}