package com.saurabh.tv.altimetriktest.base
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saurabh.tv.altimetriktest.R
import com.saurabh.tv.altimetriktest.data.model.Result
import kotlinx.android.synthetic.main.item_layout.view.*

class ItuneAdapter(
    private val itune: ArrayList<Result>
) : RecyclerView.Adapter<ItuneAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Result) {
            itemView.textViewArtistName.text = user.artistName
            itemView.textViewTrackName.text = user.trackName
            Glide.with(itemView.imagetrackViewUrl.context)
                .load(user.artistViewUrl)
                .into(itemView.imagetrackViewUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = itune.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(itune[position])

    fun addData(list: List<Result>) {
        itune.addAll(list)
    }

}