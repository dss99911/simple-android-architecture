@file:Suppress("unused")

package kim.jeonghyeon.kotlinlibrary.extension

inline fun <T : CharSequence?, R> T.letIfNotEmpty(action: (T) -> R): R? =
    if (this.isNullOrEmpty()) null else action(this)