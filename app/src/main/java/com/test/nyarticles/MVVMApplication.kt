package com.test.nyarticles

import android.app.Application
import com.test.nyarticles.data.network.ArticlesApi
import com.test.nyarticles.data.network.NetworkConnectionInterceptor
import com.test.nyarticles.data.repositories.ArticlesRepository
import com.test.nyarticles.ui.Articles.ArticleViewModel
import com.test.nyarticles.ui.Articles.ArticleViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(),KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ArticlesApi(instance()) }
        bind() from singleton { ArticlesRepository(instance()) }
        bind() from provider { ArticleViewModelFactory(instance()) }
        bind() from provider { ArticleViewModel(instance()) }

    }
}