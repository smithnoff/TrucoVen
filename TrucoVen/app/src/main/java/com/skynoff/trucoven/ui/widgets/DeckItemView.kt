package com.skynoff.trucoven.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.constraintlayout.widget.ConstraintLayout
import com.skynoff.trucoven.R
import com.skynoff.trucoven.background.data.models.Deck
import com.skynoff.trucoven.background.data.models.Marking
import kotlinx.android.synthetic.main.item_deck_view.view.*


class DeckItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.item_deck_view, this, true)
        initMotion()
    }

    private fun initMotion() {
        this.setOnTouchListener(object : OnSwipeTouchListener(context){
            override fun onSwipeLeft() {
                flipCardView.setFlipTypeFromRight()
                flipCardView.flipTheView()
            }

            override fun onSwipeRight() {
                flipCardView.setFlipTypeFromLeft()
                flipCardView.flipTheView()
            }
        })
    }

    fun setNumberPint(deck:Deck){
        with(deck){
            card_up_number.text = number.toString()
            card_down_number.text = number.toString()
            card_pint.setImageResource(when(marking){
                is Marking.Gold -> R.drawable.gold_pint
                is Marking.Coarse -> R.drawable.coarse_pint
                is Marking.Cup -> R.drawable.cup_pint
                is Marking.Sword -> R.drawable.sword_pint
            })
        }
    }
}

open class OnSwipeTouchListener(context: Context?) :
    OnTouchListener {
    private val gestureDetector: GestureDetector
    open fun onSwipeLeft() {}
    open fun onSwipeRight() {}
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
                ) > Companion.SWIPE_DISTANCE_THRESHOLD && Math.abs(
                    velocityX
                ) > Companion.SWIPE_VELOCITY_THRESHOLD
            ) {
                if (distanceX > 0) onSwipeRight() else onSwipeLeft()
                return true
            }
            return false
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