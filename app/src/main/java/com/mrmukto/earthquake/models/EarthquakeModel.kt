package com.mrmukto.earthquake.models
import com.google.gson.annotations.SerializedName


data class EarthquakeModel(
    @SerializedName("features")
    val features: List<Metadata>,
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("type")
    val type: String
) {
    data class Metadata(
        @SerializedName("api")
        val api: String,
        @SerializedName("count")
        val count: Int,
        @SerializedName("generated")
        val generated: Long,
        @SerializedName("status")
        val status: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String
    )
}