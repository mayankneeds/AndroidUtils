package com.mayank.androidutils.models

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<QuotesResponse>,
    val totalCount: Int,
    val totalPages: Int
)