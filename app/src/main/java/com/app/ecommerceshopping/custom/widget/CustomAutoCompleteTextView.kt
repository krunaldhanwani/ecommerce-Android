package com.app.ecommerceshopping.custom.widget

import android.content.Context
import android.graphics.Rect
import android.graphics.Typeface
import android.util.AttributeSet

class CustomAutoCompleteTextView : androidx.appcompat.widget.AppCompatAutoCompleteTextView {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyCustomFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        applyCustomFont(context, attrs)
    }

    override fun enoughToFilter(): Boolean {
        return true
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        if (focused && filter !=null) {
            performFiltering(text, 0)
        }
    }

    private fun applyCustomFont(context: Context, attrs: AttributeSet) {
        val textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL)
        typeface = selectTypeface(context, textStyle)
    }

    private fun selectTypeface(context: Context, textStyle: Int): Typeface {
        return return when (textStyle) {
            Typeface.BOLD -> Typeface.createFromAsset(context.assets, "poppins_bold.ttf")
            Typeface.NORMAL -> Typeface.createFromAsset(context.assets, "Poppins-Medium.otf")// regular
            else -> Typeface.createFromAsset(context.assets, "Poppins-Medium.otf")// regular
        }
    }

    companion object {
        const val ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android"
    }
}