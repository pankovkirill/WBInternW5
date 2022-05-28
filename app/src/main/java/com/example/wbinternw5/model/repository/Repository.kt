package com.example.wbinternw5.model.repository

interface Repository<T> {
    suspend fun getData(): T
}