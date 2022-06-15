package com.mrmukto.earthquake.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrmukto.earthquake.models.EarthquakeModel
import com.mrmukto.earthquake.repos.EarthquakeRepository
import kotlinx.coroutines.launch

class EarthquakeViewModel: ViewModel() {
    val repository = EarthquakeRepository()

    val earthquakeLiveData: MutableLiveData<EarthquakeModel> = MutableLiveData()

    fun fetchData() {
        viewModelScope.launch {
            try {
                earthquakeLiveData.value = repository.fetchCurrentData()
                //Log.d("EarthquakeViewModel", "${repository.fetchCurrentData()}")
            }catch (e: Exception) {
                Log.d("EarthquakeViewModel", e.localizedMessage)
            }
        }
    }
}