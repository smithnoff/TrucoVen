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
import com.skynoff.trick.background.factories.SpainCardFactory
import com.skynoff.trick.background.model.SpainCard
import com.skynoff.trick.background.model.SpainDeck
import com.skynoff.trick.background.model.SpainMark
import com.skynoff.trick.background.model.SpainMarking
import kotlinx.android.synthetic.main.fragment_game_table.*
import java.security.SecureRandom
import kotlin.random.Random

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

        val randomValues = List(3) { Random.nextInt(1, 11) }

        card_one.setNumberPint(
            SpainCardFactory().createCard(randomValues[0],SpainMark.values()[SecureRandom().nextInt(SpainMark.values().size)])
        )
        card_two.setNumberPint(
            SpainCardFactory().createCard(randomValues[1],SpainMark.values()[SecureRandom().nextInt(SpainMark.values().size)])
        )
        card_three.setNumberPint(
            SpainCardFactory().createCard(randomValues[2],SpainMark.values()[SecureRandom().nextInt(SpainMark.values().size)])
        )
    }
}