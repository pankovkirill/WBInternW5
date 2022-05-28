package com.example.wbinternw5.model.data

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/api/heroStats")
    fun getDataAsync(): Deferred<List<DataModel>>
}