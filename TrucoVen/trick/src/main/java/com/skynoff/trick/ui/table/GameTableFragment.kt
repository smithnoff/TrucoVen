package com.skynoff.trick.ui.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.skynoff.base.widgets.CardFlowAdapter
import com.skynoff.base.widgets.CardViewAdapter
import com.skynoff.trick.R
import com.skynoff.trick.background.factories.SpainCardFactory
import com.skynoff.trick.background.model.SpainDeck
import com.skynoff.trick.background.model.SpainMark
import kotlinx.android.synthetic.main.fragment_game_table.*
import java.security.SecureRandom
import kotlin.random.Random

class GameTableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_game_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spainDeck = SpainDeck()
        spainDeck.createFullDeck()
        val randomValues = List(3) { Random.nextInt(1, 12) }
        val adapter = CardFlowAdapter()
        adapter.mData = mutableListOf(
            SpainCardFactory().createCard(
                randomValues[0],
                SpainMark.values()[SecureRandom().nextInt(SpainMark.values().size)]
            ),
            SpainCardFactory().createCard(
                randomValues[1],
                SpainMark.values()[SecureRandom().nextInt(SpainMark.values().size)]
            ),
            SpainCardFactory().createCard(
                randomValues[2],
                SpainMark.values()[SecureRandom().nextInt(SpainMark.values().size)]
            )
        )
        featureCoverFlow.adapter = adapter
    }
}