package com.test.nyarticles.ui.Articles

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.test.nyarticles.R
import com.test.nyarticles.data.model.Articles
import com.test.nyarticles.data.model.Result
import com.test.nyarticles.ui.Articles.Adapter.ArticleAdapter
import com.test.nyarticles.ui.ArticlesDetails.ArticleDetailActivity
import com.test.nyarticles.utilz.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.article_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ArticleFragment : Fragment(), KodeinAware, RecyclerViewClickListener,ArticleListner{


    override val kodein by kodein()

    companion object {
        fun newInstance() = ArticleFragment()
    }

    private lateinit var viewModel: ArticleViewModel

    private val factory : ArticleViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(ArticleViewModel::class.java)
        try{
            Coroutines.main{
                viewModel.getArticle()
            }

            viewModel.article.observe(viewLifecycleOwner, Observer { articles ->
                recycler_view_list.also {

                    it.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL ,false)
                    it.setHasFixedSize(true)
                    it.adapter = ArticleAdapter(articles, this)
                }
            })
        }catch (e : Exception){context?.toast("No Internet Connection")}
    }

    override fun onRecyclerViewItemClick(view: View, result: Result) {
        val intent = Intent(context, ArticleDetailActivity::class.java)
        intent.putExtra("Title", result.title)
        intent.putExtra("Author", result.byline)
        intent.putExtra("Date", result.published_date)
        intent.putExtra("Abstract", result.abstract)
        intent.putExtra("Image", result.media.get(0).mediametadata.get(2).url)
        startActivity(intent)
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSucess(article: LiveData<List<Result>>) {
        progress_bar.hide()
    }

    override fun onFailed(message: String) {
        progress_bar.hide()
    }

}
