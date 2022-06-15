package com.mrmukto.earthquake.network

import com.mrmukto.earthquake.models.EarthquakeModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url
import java.text.SimpleDateFormat
import java.util.*

const val base_url="https://earthquake.usgs.gov/"

fun getFormattedDate(dt: Long, pattern: String) : String {
    return SimpleDateFormat(pattern).format(Date(dt * 1000))
}

val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
interface EarthquakeApi {

    @GET
    suspend fun getEarthquake(@Url endUrl: String) : EarthquakeModel
}
object NetworkService{
val earthquakeApi: EarthquakeApi by lazy {
    retrofit.create(EarthquakeApi::class.java)
    }
}