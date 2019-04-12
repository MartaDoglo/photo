package com.example.photo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view_photo.view.*

class PhotoAdapter(val context: Context?, val items: ArrayList<Photo>, val clickListener: onItemClickListener) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_photo, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        p0?.tvPhoto?.setImageResource(items.get(position).photo)
        p0.itemView.setOnClickListener { v : View -> clickListener.onItemClick(items.get(position)) }
    }

    interface onItemClickListener {
        fun onItemClick (item : Photo)
    }

    fun insertItem (item : Photo){
        items.add(1,item)
        //notyfyItemInserted(1)
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val tvPhoto = view.ivAvatar

}