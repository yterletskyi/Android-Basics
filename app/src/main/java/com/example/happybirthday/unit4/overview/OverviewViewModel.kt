package com.example.happybirthday.unit4.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happybirthday.unit4.network.MarsApi
import com.example.happybirthday.unit4.network.MarsPhoto
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */

enum class MarsApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MarsApiStatus> = _status

    private val _photos = MutableLiveData<List<MarsPhoto>>()

    val photos: LiveData<List<MarsPhoto>> = _photos

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {
        _status.value = MarsApiStatus.LOADING
        try {
            viewModelScope.launch {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.DONE
            }
        } catch (e: Exception) {
            _status.value = MarsApiStatus.ERROR
            _photos.value = listOf()
        }
    }
}