package com.test.nyarticles.data.repositories

import com.test.nyarticles.data.model.Articles
import com.test.nyarticles.data.model.Result
import com.test.nyarticles.data.network.ArticlesApi
import com.test.nyarticles.data.network.SafeApiRequest

class ArticlesRepository (
    private val api: ArticlesApi
) : SafeApiRequest() {

    suspend fun ArticlesData(): Articles {
        return apiRequest{api.getArticles()}
    }

}

