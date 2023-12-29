package com.example.newsapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.domain.MyNews

class GlobalNewsDiffCallback(
    private val oldList: List<MyNews>,
    private val newList: List<MyNews>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].url == newList[newItemPosition].url
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}

class GlobalNewsAdapter(myNewsList: List<MyNews>) :
    RecyclerView.Adapter<GlobalNewsAdapter.ViewHolder>() {
    private var listNews = myNewsList.filter { it.title != "[Removed]" }
        set(newValue) {
            val diffCallback = GlobalNewsDiffCallback(field, newValue)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
            field = newValue
        }

    var onItemClick: ((MyNews) -> Unit)? = null

    inner class ViewHolder(
        itemView: View,
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle),
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription),
        val textViewAuthor: TextView = itemView.findViewById(R.id.textViewAuthor),
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(listNews[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.top_news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = listNews[position]
        holder.textViewTitle.text = item.title
        holder.textViewDescription.text = String.format(
            context.getString(
                R.string.top_news_description
            ),
            item.description
        )
        holder.textViewAuthor.text =
            String.format(context.getString(R.string.published_by), item.author)
        Glide.with(context)
            .load(item.urlToImage)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}