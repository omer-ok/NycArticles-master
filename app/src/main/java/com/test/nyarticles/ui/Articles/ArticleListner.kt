package com.test.nyarticles.ui.Articles

import androidx.lifecycle.LiveData
import com.test.nyarticles.data.model.Result

interface ArticleListner {

    fun onStarted()
    fun onSucess(article: LiveData<List<Result>>)
    fun onFailed(message:String)

}