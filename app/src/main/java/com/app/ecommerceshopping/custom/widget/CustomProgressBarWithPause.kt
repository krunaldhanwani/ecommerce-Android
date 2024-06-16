package  com.app.ecommerceshopping.custom.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

import androidx.viewpager.widget.ViewPager

class CustomProgressBarWithPause @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ViewPager(context, attrs) {
    // prevent NPE if fake dragging and touching ViewPager
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return if (isFakeDragging) {
            false
        } else try {
            super.onInterceptTouchEvent(ev)
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}