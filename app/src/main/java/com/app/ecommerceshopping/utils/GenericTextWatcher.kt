package com.app.ecommerceshopping.utils

import android.content.ClipboardManager
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import com.app.ecommerceshopping.custom.widget.CustomEditText

class OtpEditText(private val ctx:Context,
                  private val edtPin1: CustomEditText,
                  private val edtPin2: CustomEditText,
                  private val edtPin3: CustomEditText,
                  private val edtPin4: CustomEditText
) {

    private val textWatcher1: GenericTextWatcher = GenericTextWatcher(edtPin1, edtPin1, edtPin2, edtPin3, edtPin4)
    private val textWatcher2: GenericTextWatcher = GenericTextWatcher(edtPin2, edtPin1, edtPin2, edtPin3, edtPin4)
    private val textWatcher3: GenericTextWatcher = GenericTextWatcher(edtPin3, edtPin1, edtPin2, edtPin3, edtPin4)
    private val textWatcher4: GenericTextWatcher = GenericTextWatcher(edtPin4, edtPin1, edtPin2, edtPin3, edtPin4)

    init {
        edtPin1.addTextChangedListener(textWatcher1)
        edtPin2.addTextChangedListener(textWatcher2)
        edtPin3.addTextChangedListener(textWatcher3)
        edtPin4.addTextChangedListener(textWatcher4)

        edtPin1.addListener(object : CustomEditText.GoEditTextListener {
            override fun onUpdate() {
                setTextToOtpEditText()
            }
        })
        edtPin2.addListener(object : CustomEditText.GoEditTextListener {
            override fun onUpdate() {
                setTextToOtpEditText()
            }
        })
        edtPin3.addListener(object : CustomEditText.GoEditTextListener {
            override fun onUpdate() {
                setTextToOtpEditText()
            }
        })
        edtPin4.addListener(object : CustomEditText.GoEditTextListener {
            override fun onUpdate() {
                setTextToOtpEditText()
            }
        })
    }

    private fun getIntFromClipBoard() = safeInt((ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).text.toString(),-1)

    fun removeOnTextChangeObserver() {
        edtPin1.removeTextChangedListener(textWatcher1)
        edtPin2.removeTextChangedListener(textWatcher2)
        edtPin3.removeTextChangedListener(textWatcher3)
        edtPin4.removeTextChangedListener(textWatcher4)
    }

    fun setTextToOtpEditText(){

        val text = getIntFromClipBoard()

        if (text==-1){
            return
        }

        var myClip=text.toString()

        if(myClip.length>6) {
            myClip = myClip.substring(0, 5)
        }

        try {
            edtPin1.setText(myClip[0].toString())
            edtPin1.setSelection(edtPin1.text!!.length)
            edtPin2.setText(myClip[1].toString())
            edtPin2.setSelection(edtPin2.text!!.length)
            edtPin3.setText(myClip[2].toString())
            edtPin3.setSelection(edtPin3.text!!.length)
            edtPin4.setText(myClip[3].toString())
            edtPin4.setSelection(edtPin4.text!!.length)
        } catch (e:Exception){

        }
    }

    private fun safeInt(text: String, fallback: Int): Int {
        return text.toIntOrNull() ?: fallback
    }

    var text:String
    get() {
        return edtPin1.text.toString()+edtPin2.text.toString()+edtPin3.text.toString()+edtPin4.text.toString()
    }
    set(value) {
        try {
            val data=safeInt(value,-1)
            if (data==-1){
                return
            }
            val myClip=data.toString()
            edtPin1.setText(myClip[0].toString())
            edtPin1.setSelection(edtPin1.text!!.length)
            edtPin2.setText(myClip[1].toString())
            edtPin2.setSelection(edtPin2.text!!.length)
            edtPin3.setText(myClip[2].toString())
            edtPin3.setSelection(edtPin3.text!!.length)
            edtPin4.setText(myClip[3].toString())
            edtPin4.setSelection(edtPin4.text!!.length)
        }catch (e:Exception){

        }
    }

}

class GenericTextWatcher constructor(private val view: View,
                                     val edt_pin1: EditText,
                                     val edt_pin2: EditText,
                                     val edt_pin3: EditText,
                                     val edt_pin4: EditText) : TextWatcher {

    override fun afterTextChanged(editable: Editable) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        val text = s.toString()
//        when (view.id) {
//            R.id.etOtpOne -> {
//                if (text.length == 1) {
//                    edt_pin2.requestFocus()
//                    edt_pin2.setSelection(edt_pin2.text.length)
//                }
//            }
//            R.id.etOtpTwo -> {
//                if (text.length == 1){
//                    edt_pin3.requestFocus()
//                    edt_pin3.setSelection(edt_pin3.text.length)
//                } else if (text.isEmpty()){
//                    edt_pin1.requestFocus()
//                    edt_pin1.setSelection(edt_pin1.text.length)
//                }
//            }
//            R.id.etOtpThree -> {
//                if (text.length == 1){
//                    edt_pin4.requestFocus()
//                    edt_pin4.setSelection(edt_pin4.text.length)
//                } else if (text.isEmpty()){
//                    edt_pin2.requestFocus()
//                    edt_pin2.setSelection(edt_pin2.text.length)
//                }
//            }
//            R.id.etOtpFour -> {
//               if (text.isEmpty()){
//                    edt_pin3.requestFocus()
//                    edt_pin3.setSelection(edt_pin3.text.length)
//                }
//            }
//        }
    }
}
