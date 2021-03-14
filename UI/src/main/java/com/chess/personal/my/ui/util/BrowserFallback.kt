package com.chess.personal.my.ui.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.chess.personal.my.ui.R
import com.novoda.simplechromecustomtabs.navigation.NavigationFallback
import java.lang.ref.WeakReference

/**
 * A fallback to open the url in the browser
 */
class BrowserFallback(context: Context) : NavigationFallback {

    private val context: WeakReference<Context> = WeakReference(context)

    override fun onFallbackNavigateTo(url: Uri) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url
        val context = this.context.get() ?: return
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, R.string.error_no_browser, Toast.LENGTH_SHORT)
                    .show()
        }

    }
}