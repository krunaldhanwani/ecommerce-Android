package  com.app.todo.utils

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.lang3.StringEscapeUtils
import java.util.regex.Pattern

val isPostcode = Pattern.compile("^(?i)(?=.{7,50}\$)(([0-9a-zA-ZÀ-ÿ]+[0-9a-zA-ZÀ-ÿ_]*[-\\\\._\\\\+&])*[0-9a-zA-ZÀ-ÿ]+)@([-0-9a-zA-ZÀ-ÿ]+[.])+([a-zA-ZÀ-ÿ]{2}|(aero|arpa|biz|com|coop|edu|gov|info|int|mil|mobi|museum|name|net|org|pro|travel|us))\$")

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.inivisible() {
    visibility = View.INVISIBLE
}

fun View.closeKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

class HorizontalMarginItemDecoration(context: Context, @DimenRes horizontalMarginInDp: Int) :
    RecyclerView.ItemDecoration() {
    private val horizontalMarginInPx: Int =
        context.resources.getDimension(horizontalMarginInDp).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.right = horizontalMarginInPx
        outRect.left = horizontalMarginInPx
    }
}


//@SuppressLint("LogNotTimber")
//fun showLog(type: Constant.LogType, tag: String, message: Any) {
//    when (type) {
//        Constant.LogType.verbose -> {
//            Log.v(tag, message.toString())
//        }
//        Constant.LogType.debug -> {
//            Log.d(tag, message.toString())
//        }
//        Constant.LogType.info -> {
//            Log.i(tag, message.toString())
//        }
//        Constant.LogType.error -> {
//            Log.e(tag, message.toString())
//        }
//        Constant.LogType.warn -> {
//            Log.w(tag, message.toString())
//        }
//    }
//}
//
//fun showVerboseLog(tag: String, message: Any) {
//    showLog(Constant.LogType.verbose, tag, message)
//}
//fun showDebugLog(tag: String, message: Any) {
//    showLog(Constant.LogType.debug, tag, message)
//}
//fun showInfoLog(tag: String, message: Any) {
//    showLog(Constant.LogType.info, tag, message)
//}
//fun showErrorLog(tag: String, message: Any) {
//    showLog(Constant.LogType.error, tag, message)
//}
//fun showWarnLog(tag: String, message: Any) {
//    showLog(Constant.LogType.warn, tag, message)
//}



fun openLocationInMap(lat: String, lng: String, location: String, context: Context) {
    val uriBegin = "geo:$lat,$lng"
    val query = "$lat,$lng($location)"
    val encodedQuery = Uri.encode(query)
    val uriString = "$uriBegin?q=$encodedQuery&z=16"
    val uri = Uri.parse(uriString)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}

fun String.isValidEmail() = !isNullOrEmpty() && isPostcode.matcher(this).matches()
//fun String.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidMobile() = !isNullOrEmpty() && Patterns.PHONE.matcher(this).matches()

fun String.isValidPassword() = this.length > 5

//fun String?.mediaFullUrl() = if (this == null) null else MyRetrofit.mediaBaseUrl.plus(this)

fun getMapImageURL(latitude: String, longitude: String, size: String): String {
    return "http://maps.google.com/maps/api/staticmap?center=$latitude,$longitude&zoom=15&size=$size&sensor=false&key=AIzaSyDC528LWI3jsJSPQLJErgtL5urzOIQHBhg"
}

fun String?.decodeEmoji(): String = if (this == null) "" else StringEscapeUtils.unescapeJava(this)