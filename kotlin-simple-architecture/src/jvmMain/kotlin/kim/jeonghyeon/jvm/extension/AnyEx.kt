@file:Suppress("unused")

package kim.jeonghyeon.jvm.extension

import com.google.gson.Gson
import com.google.gson.GsonBuilder

fun Any?.printAsJson() {
    println(
        GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
            .toJson(this)
    )
}

fun Any?.toJsonString(): String? = if (this == null) null else Gson().toJson(this)