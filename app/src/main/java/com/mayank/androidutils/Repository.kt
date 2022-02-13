package com.mayank.androidutils

import com.mayank.androidutils.common.network.ApiService
import com.mayank.androidutils.models.QuoteList
import com.mayank.androidutils.models.QuotesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQuotes() = apiService.getQuotes()
}