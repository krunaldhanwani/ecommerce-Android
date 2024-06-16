package com.app.ecommerceshopping.ui.home.adapter

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.app.ECommerceShopping.R


class CategoryAdaptor :  RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.raw_category, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { }

    override fun getItemCount() = 5

}
