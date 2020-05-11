package com.skynoff.base.widgets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.skynoff.base.R
import com.skynoff.base.model.Card


class CardFlowAdapter : BaseAdapter() {

    var mData = mutableListOf<Card>()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val vh: ViewHolder?
        val convertView: View?
        if (p1 == null) {
            vh = ViewHolder()
            val vi =
                p2?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = vi.inflate(R.layout.item_deck_view, p2, false)
            vh.upNumber = convertView.findViewById(R.id.card_up_number)
            vh.downNumber = convertView.findViewById(R.id.card_down_number)
            vh.thumb_image = convertView.findViewById(R.id.card_pint)

            convertView.tag = convertView
        } else {
            convertView = p1
            vh = convertView.tag as ViewHolder
        }
      vh.upNumber?.text = mData[p0].number.toString()
      vh.downNumber?.text = mData[p0].number.toString()
      vh.thumb_image?.setImageResource(
          p2?.context?.resources?.getIdentifier(
              "${mData[p0].marking.getMarkSrc()}_${mData[p0].number}",
              "drawable",
             p2.context.packageName
          )!!
      )
        return convertView!!
    }

    override fun getItem(p0: Int) = mData[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getCount() = mData.size

}

internal class ViewHolder {
    var upNumber: TextView? = null
    var downNumber: TextView? = null
    var thumb_image: ImageView? = null
}