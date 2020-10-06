package com.test.nyarticles.ui.Articles

import android.view.View
import com.test.nyarticles.data.model.Articles
import com.test.nyarticles.data.model.Result

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, result: Result)
}