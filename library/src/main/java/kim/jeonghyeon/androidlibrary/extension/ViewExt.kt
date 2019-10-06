package kim.jeonghyeon.androidlibrary.extension

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(snackbarText: String, @Snackbar.Duration timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).show()
}