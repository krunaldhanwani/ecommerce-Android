package com.app.ecommerceshopping.ui.home.activity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity
import com.app.ecommerceshopping.ui.home.adapter.FavouriteAdapter
import com.app.ecommerceshopping.ui.home.adapter.NewArrivedProductAdapter
import kotlinx.android.synthetic.main.activity_favourite.*
import kotlinx.android.synthetic.main.fragment_home.*

class FavouriteActivity : CustomAppCompatActivity() {
    private lateinit var favouriteAdapter: FavouriteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        initData()
    }

    override fun initData() {
        rvFavouriteProduct

        favouriteAdapter = FavouriteAdapter()
        rvFavouriteProduct.layoutManager = GridLayoutManager(this,2)
        rvFavouriteProduct.adapter = favouriteAdapter
    }
}