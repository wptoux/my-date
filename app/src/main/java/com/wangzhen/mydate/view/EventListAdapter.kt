package com.wangzhen.mydate.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.wangzhen.mydate.R
import com.wangzhen.mydate.model.Event

class EventListAdapter(context: Context, resourceId: Int, objects: List<Event>) :
        ArrayAdapter<Event>(context, resourceId, objects) {

    private val _resourceId = resourceId

    private val _inflator: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val vh: ViewHolder
        if (convertView == null) {
            view = this._inflator.inflate(R.layout.event_list_item, parent, false)

            val icon = view.findViewById(R.id.icon) as ImageView
            val tvEvent = view.findViewById(R.id.tvEvent) as TextView
            val tvDate = view.findViewById(R.id.tvDate) as TextView
            val tvCount = view.findViewById(R.id.tvCount) as TextView
            vh = ViewHolder(icon, tvEvent, tvDate, tvCount)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

//        vh.label.text = sList[position]
        return view!!
    }
}

private class ViewHolder(
        val icon: ImageView,
        val tvEvent: TextView,
        val tvDate: TextView,
        val tvCount: TextView)