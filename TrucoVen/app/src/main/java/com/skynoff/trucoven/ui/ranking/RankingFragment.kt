package com.skynoff.trucoven.ui.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.skynoff.trucoven.R
import com.skynoff.trucoven.background.data.models.GamePlayer
import com.skynoff.trucoven.ui.ranking.models.RankPlayer
import kotlinx.android.synthetic.main.fragment_ranking.*

class RankingFragment : Fragment() {

    private lateinit var dashboardViewModel: RankingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(RankingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ranking, container, false)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_ranking.layoutManager =LinearLayoutManager(context)
        rv_ranking.setHasFixedSize(true)
        val gamePlayer=GamePlayer("",0,0,0,0,false)
        rv_ranking.adapter=RankingAdapter(listOf(
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer),
            RankPlayer("Player ",1300,gamePlayer)
        ))
        rv_ranking.adapter?.notifyDataSetChanged()
    }
}
