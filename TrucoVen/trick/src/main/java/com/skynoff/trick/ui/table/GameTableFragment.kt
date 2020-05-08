package com.skynoff.trick.ui.table

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.skynoff.base.model.Deck
import com.skynoff.base.model.Marking
import com.skynoff.trick.R
import kotlinx.android.synthetic.main.fragment_game_table.*

class GameTableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_game_table, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_one.setNumberPint(
            Deck(
                2,
                Marking.Gold(),
                2
            )
        )
        card_two.setNumberPint(
            Deck(
                5,
                Marking.Sword(),
                5
            )
        )
        card_three.setNumberPint(
            Deck(
                7,
                Marking.Coarse(),
                7
            )
        )

        card_one.setOnClickListener(listener)
        card_two.setOnClickListener(listener)
        card_three.setOnClickListener(listener)
    }

    private val listener = View.OnClickListener {
        ViewCompat.setElevation(it, 12f);
    }
}