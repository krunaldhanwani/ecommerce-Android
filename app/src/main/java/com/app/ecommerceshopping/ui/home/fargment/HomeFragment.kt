package com.app.ecommerceshopping.ui.home.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.ui.home.activity.HomeActivity
import com.app.ecommerceshopping.ui.home.adapter.CategoryAdaptor
import com.app.ecommerceshopping.ui.home.adapter.HomeOfferBannerAdapter
import com.app.ecommerceshopping.ui.home.adapter.NewArrivedProductAdapter
import com.app.ecommerceshopping.ui.home.adapter.PopularProductAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var homeOfferBannerAdapter: HomeOfferBannerAdapter
    private lateinit var newArrivedProductAdapter: NewArrivedProductAdapter
    private lateinit var popularProductAdapter: PopularProductAdapter
    private lateinit var categoryAdaptor: CategoryAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inIt()
    }

    private fun inIt() {
        homeOfferBannerAdapter = HomeOfferBannerAdapter()
        vpBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vpBanner.offscreenPageLimit = 1
        vpBanner.adapter = homeOfferBannerAdapter
        HomeIndicator.setViewPager2(vpBanner)

        newArrivedProductAdapter = NewArrivedProductAdapter()
        rvNewArrivals.layoutManager = GridLayoutManager(activity as HomeActivity,2)
        rvNewArrivals.adapter = newArrivedProductAdapter

        popularProductAdapter = PopularProductAdapter()
        rvPopularProduct.layoutManager = GridLayoutManager(activity as HomeActivity,2)
        rvPopularProduct.adapter = popularProductAdapter

        categoryAdaptor = CategoryAdaptor()
        rvCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoryAdaptor
    }
}