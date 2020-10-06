package com.test.nyarticles.ui.Articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.nyarticles.data.repositories.ArticlesRepository

class ArticleViewModelFactory (
    private val repository: ArticlesRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>):T {
        return ArticleViewModel(repository) as T
    }
}