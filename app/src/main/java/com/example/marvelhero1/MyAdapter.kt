package com.example.marvelhero1

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelhero1.databinding.MarvelItemBinding
import com.squareup.picasso.Picasso
import java.io.Serializable

class MyAdapter: RecyclerView.Adapter<MyAdapter.MarvelHolder>() {
    private lateinit var mListener: ItemClickListener
    private val arList = ArrayList<Marvel>()

    interface ItemClickListener {
        fun onItemClick(marvel: Marvel)
       fun passData(position: Int, create: String, publ: String, fiApp: String, bio: String)
    }

    fun setOnItemClickListener(listener: ItemClickListener) {
        mListener = listener
    }

    class MarvelHolder(item: View, private val listener: ItemClickListener) :
        RecyclerView.ViewHolder(item) {
        private val binding = MarvelItemBinding.bind(item)
        fun bind(marvel: Marvel) = with(binding) {
            itemView.setOnClickListener {
                listener.onItemClick(marvel)
            }
          // TvImage.setImageResource(marvel.imageurl)
            nameText.text = marvel.name
            realNameText.text = marvel.realname
            teamText.text = marvel.team
         Picasso
             .get()
             .load("https://www.simplifiedcoding.net/demos/marvel/imageurl")
             .resize(200,200).centerCrop()
            .into(TvImage)
        }

    }

    private var data = arList
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.marvel_item, parent, false)
        return MarvelHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: MarvelHolder, position: Int) {
       // Picasso.get().load("https://www.simplifiedcoding.net/demos/marvel/imageurl")
          //  .into(data[position].imageurl)
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
    fun setMovieListItems(body: ArrayList<Marvel>) {
        data = body
    }
}

data class Marvel(
    var name: String? = null,
    var realname: String? = null,
    var team: String? = null,
    var createdby: String? = null,
    var firstappearance: String? = null,
    var publisher: String? = null,
    var imageurl: String? = null,
    var bio: String? = null
): Serializable

