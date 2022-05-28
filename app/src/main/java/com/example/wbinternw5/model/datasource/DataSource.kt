package com.example.wbinternw5.model.datasource

interface DataSource<T> {
    suspend fun getData(): T
}