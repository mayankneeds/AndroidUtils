package com.mayank.androidutils.common.network

import com.mayank.androidutils.common.network.remote.NetworkResponse
import com.mayank.androidutils.models.QuoteList
import retrofit2.http.GET

typealias GenericResponse<T> = NetworkResponse<T, Error>

interface ApiService {
    @GET("/quotes")
    suspend fun getQuotes(): GenericResponse<QuoteList>
}