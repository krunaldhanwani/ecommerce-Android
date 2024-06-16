package com.app.ecommerceshopping.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.app.ECommerceShopping.R

class LoadingDialog(val context: Context) {

    private val builder: AlertDialog.Builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
    private var alertDialog: AlertDialog

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null)
        builder.setView(view)
        builder.setCancelable(false)
        alertDialog = builder.create()
    }

    fun show() {
        alertDialog.show()
    }

    fun dismiss() {
        alertDialog.dismiss()
    }

    fun isShowing() = alertDialog.isShowing

}