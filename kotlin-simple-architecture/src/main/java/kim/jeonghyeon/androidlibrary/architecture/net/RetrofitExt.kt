package kim.jeonghyeon.androidlibrary.architecture.net

import kim.jeonghyeon.androidlibrary.architecture.net.adapter.DataCallAdapterFactory
import kim.jeonghyeon.androidlibrary.architecture.net.interceptor.BaseInterceptor
import kim.jeonghyeon.androidlibrary.extension.app
import kim.jeonghyeon.androidlibrary.util.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified API> api(baseUrl: String): API {
    return apiBuilder(baseUrl)
        .build()
        .create(API::class.java)
}

fun apiBuilder(baseUrl: String): Retrofit.Builder {
    val client = OkHttpClient.Builder().apply {
        if (!app.isProd || app.isDebug) {
            addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Logger.log(message)
                }
            }).apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        addInterceptor(BaseInterceptor())
    }.build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(DataCallAdapterFactory())
}