package com.skynoff.base.widgets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skynoff.base.R
import com.skynoff.base.model.Card
import kotlinx.android.synthetic.main.item_deck_view.view.*
import kotlinx.android.synthetic.main.item_rank_player_view.view.*

class CardViewAdapter(private val cardList: List<Card>) :
    RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = CardViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_deck_view, parent, false)
    )

    override fun getItemCount() = cardList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.bind(cardList[position])
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(card: Card) {
            with(card){
                itemView.card_down_number.text = number.toString()
                itemView.card_up_number.text = number.toString()
                itemView.card_pint.setImageResource(card.marking.getMarkSrc())
            }
        }
    }
}
