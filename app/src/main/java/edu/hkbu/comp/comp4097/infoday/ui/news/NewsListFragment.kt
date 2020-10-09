package edu.hkbu.comp.comp4097.infoday.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.News
import edu.hkbu.comp.comp4097.infoday.ui.news.dummy.DummyContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class NewsListFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

//        // Set the adapter
//        if (view is RecyclerView) {
//            with(view) {
//                layoutManager = when {
//                    columnCount <= 1 -> LinearLayoutManager(context)
//                    else -> GridLayoutManager(context, columnCount)
//                }
////                adapter = NewsRecyclerViewAdapter(DummyContent.ITEMS)
//                val newsImage = resources.getStringArray(R.array.newsImage)
//                val newsTitle = resources.getStringArray(R.array.newsTitle)
//                val newsDetail = resources.getStringArray(R.array.newsDetail)
//                val news = mutableListOf<News>()
//                for (i in 0..(newsDetail.size - 1))
//                    news.add(News(newsImage[i], newsTitle[i], newsDetail[i]))
//                adapter = NewsRecyclerViewAdapter(news)
//            }
//        }
//        return view
//        val recyclerView = inflater.inflate(R.layout.fragment_news_list, container, false) as RecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        reloadData(recyclerView)
//        return recyclerView

        val recyclerView = inflater.inflate(R.layout.fragment_news_list, null, false) as
                RecyclerView
        val swipeLayout = SwipeRefreshLayout(requireContext())
        swipeLayout.addView(recyclerView)
        swipeLayout.setOnRefreshListener {
            swipeLayout.isRefreshing = true
            reloadData(recyclerView)
            swipeLayout.isRefreshing = false
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        reloadData(recyclerView)
        return swipeLayout
    }

    private fun reloadData(recyclerView: RecyclerView) {
//        val NEWS_URL = "https://api.npoint.io/256da2ee7badc12b0ec2"
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val json = Network.getTextFromNetwork(NEWS_URL)
//                //convert the string json into List<news>
//                val news = Gson().fromJson<List<News>>(json,object : TypeToken<List<News>>() {}.type)
//                CoroutineScope(Dispatchers.Main).launch {
//                    recyclerView.adapter = NewsRecyclerViewAdapter(news)
//                }
//            } catch (e : Exception) {
//                Log.d("NewsListFragment", "reloadData: ${e}")
//            }
        val NEWS_URL = "https://api.npoint.io/256da2ee7badc12b0ec2"
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val json = Network.getTextFromNetwork(NEWS_URL)
                val news = Gson().fromJson<List<News>>(json,object :
                    TypeToken<List<News>>() {}.type)
                CoroutineScope(Dispatchers.Main).launch {
                    recyclerView.adapter = NewsRecyclerViewAdapter(news)
                }
            } catch (e: Exception) {
                Log.d("NewsListFragment", "Error in loading data")
                val news = listOf(News("", "Cannot fetch news", "Please check your network connection,"))
                        CoroutineScope(Dispatchers.Main).launch {
                    recyclerView.adapter = NewsRecyclerViewAdapter(news)
                }
            }
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            NewsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}