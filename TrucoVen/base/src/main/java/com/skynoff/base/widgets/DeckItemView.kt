package com.skynoff.base.widgets

import android.content.Context
import android.provider.ContactsContract
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.skynoff.base.R
import com.skynoff.base.model.Card
import com.skynoff.base.model.Deck
import com.skynoff.base.model.Marking
import kotlinx.android.synthetic.main.item_deck_view.view.*


class DeckItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.item_deck_view, this, true)
    }

    lateinit var cardItemview: Card

    private fun initMotion(card: Card) {
        this.flipCardView.setOnTouchListener(object : OnSwipeTouchListener(context) {

            override fun onSwipeLeft() {
                flipCardView.setFlipTypeFromRight()
                flipCardView.flipTheView()
                card.setfacing(!card_back_image.isVisible)
            }

            override fun onSwipeRight() {
                flipCardView.setFlipTypeFromLeft()
                flipCardView.flipTheView()
                card.setfacing(!card_back_image.isVisible)
            }

            override fun onClickCard() {
                Toast.makeText(
                    context,
                    "estoy boca arriba: ${cardItemview.isFaceUp}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
    }

    fun setNumberPint(card: Card) {
        cardItemview = card
        with(card) {
            card_up_number.text = number.toString()
            card_down_number.text = number.toString()
            card_pint.setImageResource(
                context.resources.getIdentifier(
                    "${card.marking.getMarkSrc()}_$number",
                    "drawable",
                    context.packageName
                )
            )
            front_card_bg.setBackgroundResource(
                context.resources.getIdentifier(
                    "bg_${card.marking.getMarkSrc()}",
                    "drawable",
                    context.packageName
                )
            )
        }
        initMotion(card)
    }
}

open class OnSwipeTouchListener(context: Context?) :
    OnTouchListener {
    private val gestureDetector: GestureDetector
    open fun onSwipeLeft() {}
    open fun onSwipeRight() {}
    open fun onClickCard() {}

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val distanceX = e2.x - e1.x
            val distanceY = e2.y - e1.y
            if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(
                    distanceX
                ) > SWIPE_DISTANCE_THRESHOLD && Math.abs(
                    velocityX
                ) > SWIPE_VELOCITY_THRESHOLD
            ) {
                if (distanceX > 0) onSwipeRight() else onSwipeLeft()
                return true
            }
            return false
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            onClickCard()
            return super.onSingleTapConfirmed(e)
        }
    }

    companion object {
        private const val SWIPE_DISTANCE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }
}