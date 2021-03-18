package com.example.myapplication.retrofit

import com.example.myapplication.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}
val networkRequests = module {
    single { provideService(get()) }
}
private fun provideService(retrofit: Retrofit): ApiInterface =
    retrofit.create(ApiInterface::class.java)




private fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    return OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder().client(client)
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}