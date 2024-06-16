package com.app.ecommerceshopping.custom.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextViewSemiBold  : AppCompatTextView {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        applyCustomFont(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
            context,
            attrs,
            defStyle
    ) {

        applyCustomFont(context, attrs)
    }

    private fun applyCustomFont(context: Context, attrs: AttributeSet) {
        val textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL)
        typeface = selectTypeface(context, textStyle)
    }

    private fun selectTypeface(context: Context, textStyle: Int): Typeface {
        return when (textStyle) {
            Typeface.BOLD -> Typeface.createFromAsset(context.assets, "Quicksand-SemiBold.ttf")
            Typeface.NORMAL -> Typeface.createFromAsset(context.assets, "Quicksand-SemiBold.ttf")// regular
            else -> Typeface.createFromAsset(context.assets, "Quicksand-SemiBold.ttf")// regular
        }
    }

    companion object {
        const val ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android"
    }
}