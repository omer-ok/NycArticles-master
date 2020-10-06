package com.test.nyarticles.ui.ArticlesDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.test.nyarticles.R
import com.test.nyarticles.utilz.loadImage

class ArticleDetailActivity : AppCompatActivity() {

    private var titleView: TextView? = null
    private var articleView: ImageView? = null
    private var articleTextView: TextView? = null
    private var articleAuthorTextView: TextView? = null
    private var articleDateTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        articleView = findViewById(R.id.articleImage) as ImageView
        titleView = findViewById(R.id.title_article) as TextView
        articleTextView = findViewById(R.id.article) as TextView
        articleAuthorTextView = findViewById(R.id.authoreName) as TextView
        articleDateTextView = findViewById(R.id.time) as TextView

        val Title = intent.getStringExtra("Title")
        val Author = intent.getStringExtra("Author")
        val Date = intent.getStringExtra("Date")
        val Abstract = intent.getStringExtra("Abstract")
        val Image = intent.getStringExtra("Image")


        loadImage(articleView!!,Image)
        titleView?.setText(Title)
        articleTextView?.setText(Abstract)
        articleDateTextView?.setText(Date)
        articleAuthorTextView?.setText(Author)


    }
}
