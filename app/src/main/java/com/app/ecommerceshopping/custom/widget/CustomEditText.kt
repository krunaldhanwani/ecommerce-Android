package com.app.ecommerceshopping.custom.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class CustomEditText  : AppCompatEditText {

    var listeners: ArrayList<GoEditTextListener> = ArrayList()

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

    fun addListener(listener: GoEditTextListener) {
        try {
            listeners.add(listener)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    private fun applyCustomFont(context: Context, attrs: AttributeSet) {
        val textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL)
        typeface = selectTypeface(context, textStyle)
    }

    private fun selectTypeface(context: Context, textStyle: Int): Typeface {
        return when (textStyle) {
            Typeface.BOLD -> Typeface.createFromAsset(context.assets, "Quicksand-Regular.ttf")
            Typeface.NORMAL -> Typeface.createFromAsset(context.assets, "Quicksand-Regular.ttf")// regular
            else -> Typeface.createFromAsset(context.assets, "Quicksand-Regular.ttf")// regular
        }
    }

    companion object {
        const val ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android"
    }

    interface GoEditTextListener {
        fun onUpdate()
    }
}