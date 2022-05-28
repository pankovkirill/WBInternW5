package com.example.wbinternw5.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbinternw5.model.data.AppState
import com.example.wbinternw5.model.data.DataModel
import com.example.wbinternw5.model.repository.Repository
import com.example.wbinternw5.model.repository.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: Repository<List<DataModel>> = RepositoryImpl()
) : ViewModel() {
    private val _data = MutableLiveData<AppState>()

    private val liveDataForViewToObserve: LiveData<AppState> = _data

    fun subscribe() = liveDataForViewToObserve

    fun getData() {
        _data.postValue(AppState.Loading)
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() = withContext(Dispatchers.IO) {
        try {
            _data.postValue(AppState.Success(repository.getData()))
        } catch (e: Throwable) {
            _data.postValue(AppState.Error(e))
        }
    }
}