package com.app.ecommerceshopping.ui.login.adapter

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.ui.login.dataclass.HomeImageSlider
import com.bumptech.glide.Glide


class HomeSlideAdapter(private val images : ArrayList<HomeImageSlider>) :  RecyclerView.Adapter<HomeSlideAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLoremIpsum: TextView = itemView.findViewById(R.id.tvLoremIpsum)
        val tvLoremDescription: TextView = itemView.findViewById(R.id.tvLoremDescription)
        val ivImages: ImageView = itemView.findViewById(R.id.ivSlide1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.raw_home_slide, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvLoremIpsum.text = images[position].welcome
        holder.tvLoremDescription.text = images[position].welcomeMsg
        Glide.with(holder.itemView.context)
            .load(images[position].image)
            .into(holder.ivImages)
    }

    override fun getItemCount() = 3

}
