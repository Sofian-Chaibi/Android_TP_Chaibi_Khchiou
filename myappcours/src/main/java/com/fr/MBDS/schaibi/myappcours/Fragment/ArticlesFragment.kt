package com.fr.MBDS.schaibi.myappcours.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fr.MBDS.schaibi.myappcours.Article
import com.fr.MBDS.schaibi.myappcours.ArticleAdapter
import com.fr.MBDS.schaibi.myappcours.R

class ArticlesFragment (var planete:String ): Fragment(){
    /**
     * Ici, on associe le layout à afficher dans le fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doTheJob(view)
    }

    fun doTheJob(root:View)
    {
        val recyclerView = root.findViewById(R.id.recycle) as RecyclerView
        //créer une liste d'articles
        val articles = listOf<Article>(
            Article(planete,"dkfdklrfdsklnfkjdngkjndfkjngdkjndfkjgn"),
            Article(planete,"dkfdklrfdsklnfkjdngkjndfkjngdkjndfkjgn"),
            Article(planete,"dkfdklrfdsklnfkjdngkjndfkjngdkjndfkjgn")
        )
        //créer une instance de l'adapteur
        val adapterRecycler = ArticleAdapter(articles)
        //définir l'orientation des élements (vertical)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        //associer l'adapter à la recyclerview
        recyclerView.adapter = adapterRecycler
    }
}