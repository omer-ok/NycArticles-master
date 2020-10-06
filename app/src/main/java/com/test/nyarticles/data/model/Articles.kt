package com.test.nyarticles.data.model

data class Articles(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)