package com.mayank.androidutils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayank.androidutils.common.network.GenericResponse
import com.mayank.androidutils.common.network.remote.NetworkResponse
import com.mayank.androidutils.common.network.Resource
import com.mayank.androidutils.models.QuoteList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _quotesLiveData = MutableLiveData<Resource<QuoteList>>()
    val quotesLiveData get() = _quotesLiveData

    private fun <T : Any> parseResponse(
        response: GenericResponse<T>,
        liveData: MutableLiveData<Resource<T>>
    ) {
        liveData.postValue(
            when (response) {
                is NetworkResponse.Success -> Resource.success(response.body)
                is NetworkResponse.ApiError -> Resource.error(response.body.message)
                is NetworkResponse.NetworkError -> Resource.error("NetworkError")
                is NetworkResponse.UnknownError -> Resource.error("UnknownError")
            }
        )
    }

    fun getQuotes() = viewModelScope.launch {
        _quotesLiveData.postValue(Resource.loading())
        val response = repository.getQuotes()
        parseResponse(response, _quotesLiveData)
    }
}