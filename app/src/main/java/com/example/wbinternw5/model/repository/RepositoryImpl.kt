package com.example.wbinternw5.model.repository

import com.example.wbinternw5.model.data.DataModel
import com.example.wbinternw5.model.datasource.DataSource
import com.example.wbinternw5.model.datasource.RetrofitImpl

class RepositoryImpl(
    private val dataSource: DataSource<List<DataModel>> = RetrofitImpl()
) : Repository<List<DataModel>> {
    override suspend fun getData(): List<DataModel> {
        return dataSource.getData()
    }
}