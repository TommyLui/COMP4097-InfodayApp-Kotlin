package edu.hkbu.comp.comp4097.infoday.ui.news

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import edu.hkbu.comp.comp4097.infoday.R
import edu.hkbu.comp.comp4097.infoday.data.News

import edu.hkbu.comp.comp4097.infoday.ui.news.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class NewsRecyclerViewAdapter(
//    private val values: List<DummyItem> //Change this line
    private val values: List<News>
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news_item, parent, false)
        return ViewHolder(view)
    }
    //Change this function
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = values[position]
//        holder.titleTextView.text = item.title
//        holder.detailTextView.text = item.detail
//        Picasso.get().load(item.image).into(holder.newsImageView)
        val item = values[position]
        holder.titleTextView.text = item.title
        holder.detailTextView.text = item.detail
        if (item.image != "")
            Picasso.get().load(item.image).into(holder.newsImageView)
        else

            holder.newsImageView.setImageDrawable(holder.itemView.context.getDrawable(R.drawable.ic_baseline_cloud_download_24))
    }
    override fun getItemCount(): Int = values.size
    //Change this class
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsImageView: ImageView = view.findViewById(R.id.newsImageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val detailTextView: TextView = view.findViewById(R.id.detailTextView)
        override fun toString(): String {
            return super.toString() + " '" + titleTextView.text + "'"
        }
    }

}