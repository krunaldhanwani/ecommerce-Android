package com.app.ecommerceshopping.ui.login.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity
import com.app.ecommerceshopping.ui.login.adapter.HomeSlideAdapter
import com.app.ecommerceshopping.ui.login.dataclass.HomeImageSlider
import com.app.todo.utils.hide
import com.app.todo.utils.show
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : CustomAppCompatActivity() {
    private lateinit var homeSlideAdapter: HomeSlideAdapter
    private val images = ArrayList<HomeImageSlider>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        addData()
        initData()
        setViewClicks()

    }

    override fun initData() {
        ivNext.show()
        tvLetStarted.hide()
        homeSlideAdapter = HomeSlideAdapter(images)
        vpImageSlider.adapter = homeSlideAdapter
        vpImageSlider.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        vpImageSlider.offscreenPageLimit = 1
        dots_indicator.setViewPager2(vpImageSlider)


    }

    private fun getItem(i: Int): Int {
        return vpImageSlider.currentItem + i
    }

    private fun setViewClicks() {
        ivNext.setOnClickListener {
            vpImageSlider.setCurrentItem(getItem(+1), true)
            if (vpImageSlider.currentItem == 2) {
                ivNext.hide()
                tvLetStarted.show()
            } else {
                ivNext.show()
                tvLetStarted.hide()
            }
        }

        tvLetStarted.setOnClickListener {
            startActivity(Intent(this,AuthenticationActivity::class.java))
        }
    }

    private fun addData() {
        images.add(HomeImageSlider(getString(R.string.lorem_ipsum),getString(R.string.lorem_ipsum_msg),R.drawable.welcome_first_image))
        images.add(HomeImageSlider(getString(R.string.lorem_ipsum),getString(R.string.lorem_ipsum_msg),R.drawable.welcome_second_image))
        images.add(HomeImageSlider(getString(R.string.lorem_ipsum),getString(R.string.lorem_ipsum_msg),R.drawable.welcome_third_image))
    }
}