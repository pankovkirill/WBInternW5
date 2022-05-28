package com.example.wbinternw5.model.datasource

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.wbinternw5.model.data.ApiService
import com.example.wbinternw5.model.data.DataModel
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.stream.Collectors

class RetrofitImpl : DataSource<List<DataModel>> {
    override suspend fun getData(): List<DataModel> {
        return getService().getDataAsync().await()
    }

    private fun getService(): ApiService {
        return createRetrofit().create(ApiService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://api.opendota.com"
    }
}