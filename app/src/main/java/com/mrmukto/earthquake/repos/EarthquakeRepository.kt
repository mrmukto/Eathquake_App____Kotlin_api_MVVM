package com.mrmukto.earthquake.repos

import com.mrmukto.earthquake.models.EarthquakeModel
import com.mrmukto.earthquake.network.NetworkService

class EarthquakeRepository {
    suspend fun fetchCurrentData(): EarthquakeModel {
        val endUrl =
            "fdsnws/event/1/query?format=geojson&starttime=2021-01-20&endtime=2022-01-20&minmagnitude=5"
        return NetworkService.earthquakeApi
            .getEarthquake(endUrl)
    }
}