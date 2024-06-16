package com.app.ecommerceshopping.ui.home.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity
import com.app.ecommerceshopping.ui.home.fargment.HomeFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : CustomAppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
//    private lateinit var searchFragment: SearchFragment
//    private lateinit var profileFragment: ProfileFragment
//    private lateinit var categoryFragment: CategoryFragment
//    private lateinit var bookingFragment: BookingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setOnClicks()
        initData()
    }

    override fun initData() {
        homeFragment = HomeFragment()

        changeFragment(0)

    }

    /** this function used for handle activity click action **/
    private fun setOnClicks() {
        clHome.setOnClickListener { changeFragment(0) }

        clExplore.setOnClickListener { changeFragment(1) }

        clCart.setOnClickListener { changeFragment(2) }

        clOrder.setOnClickListener { changeFragment(3) }

        clAccount.setOnClickListener { changeFragment(4) }

        icFavourite.setOnClickListener { startActivity(Intent(this,FavouriteActivity::class.java))}

    }


    /** this function used for change fragment **/
    private fun changeFragment(arg : Int) {
        ivHome.setImageResource(R.drawable.ic_home)
        ivExplore.setImageResource(R.drawable.ic_search)
        ivCart.setImageResource(R.drawable.ic_cart)
        ivOrder.setImageResource(R.drawable.ic_order)
        ivAccount.setImageResource(R.drawable.ic_profile)

        tvHome.setTextColor(resources.getColor(R.color.ColorGreyB1))
        tvExplore.setTextColor(resources.getColor(R.color.ColorGreyB1))
        tvCart.setTextColor(resources.getColor(R.color.ColorGreyB1))
        tvOrder.setTextColor(resources.getColor(R.color.ColorGreyB1))
        tvAccount.setTextColor(resources.getColor(R.color.ColorGreyB1))
        when (arg) {
            0 -> {
                transactFragment(homeFragment)
                ivHome.setImageResource(R.drawable.ic_home_selected)
                tvHome.setTextColor(resources.getColor(R.color.colorOrange53))

            }
            1 -> {
//            ivExplore.setImageResource(R.drawable.ic_search_selected_icon)
                tvExplore.setTextColor(resources.getColor(R.color.colorOrange53))
            }
            2 -> {
//                    ivBooking.setImageResource(R.drawable.ic_booking_selected_icon)
//                    ivBookingSelected.show()
//                    llSearchHeader.hide()
//                    llMainHeader.show()
//                    tvHeader.text = getString(R.string.my_orders)
//                    transactFragment(bookingFragment)
//                    llMain.setBackgroundColor(getColor(R.color.blueFF))
                tvCart.setTextColor(resources.getColor(R.color.colorOrange53))
            }
            3 -> {
                ivOrder.setImageResource(R.drawable.ic_order_selected)
//                    ivMessage.setImageResource(R.drawable.ic_message_selected_icon)
//                    ivMessageSelected.show()
//                    llSearchHeader.hide()
//                    llMainHeader.show()
//                    tvHeader.text = getString(R.string.Message)
//                    transactFragment(messageFragment)
//                    llMain.setBackgroundColor(getColor(R.color.white))
                tvOrder.setTextColor(resources.getColor(R.color.colorOrange53))
                }
            4 -> {
                ivAccount.setImageResource(R.drawable.ic_profile_selected)
//                ivProfile.setImageResource(R.drawable.ic_profile_selected_icon)
//                ivProfileSelected.show()
//                llSearchHeader.hide()
//                llMainHeader.show()
//                tvHeader.text = getString(R.string.Profile)
//                transactFragment(profileFragment)
                tvAccount.setTextColor(resources.getColor(R.color.colorOrange53))
            }

        }
    }


    private fun transactFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }
}
