package com.test.nyarticles.ui.Articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.nyarticles.data.model.Articles
import com.test.nyarticles.data.model.Result
import com.test.nyarticles.data.repositories.ArticlesRepository
import com.test.nyarticles.utilz.ApiException
import com.test.nyarticles.utilz.Coroutines
import com.test.nyarticles.utilz.NoInternetException
import com.test.nyarticles.utilz.genericCastOrNull
import kotlinx.coroutines.Job

class ArticleViewModel(
    private val repository: ArticlesRepository
) : ViewModel() {
    private lateinit var job: Job
    var ArticleListner : ArticleListner?=null

    private val _article = MutableLiveData<List<Result>>()
    val article: LiveData<List<Result>>
        get() = _article

    fun getArticle() {
        try{
            job = Coroutines.ioThenMain(
                {repository.ArticlesData() },
                { _article.value = genericCastOrNull(it?.results)
                }
            )
        }catch (e : ApiException){ArticleListner?.onFailed(e.message!!)
        }catch (e : NoInternetException){ArticleListner?.onFailed(e.message!!)}


    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}
