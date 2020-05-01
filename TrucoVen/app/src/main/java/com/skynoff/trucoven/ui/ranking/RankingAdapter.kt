package com.skynoff.trucoven.ui.ranking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skynoff.trucoven.R
import com.skynoff.trucoven.ui.ranking.models.RankPlayer

class RankingAdapter(private val rankList: List<RankPlayer>) :
    RecyclerView.Adapter<RankingAdapter.RankingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RankingViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rank_player_view, parent, false)
        )

    override fun getItemCount() = rankList.size

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        holder.bind(rankList[position])
    }


    class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(rankPlayer: RankPlayer) {

        }
    }
}