package com.example.insystems.di.modules

import com.example.insystems.data.network.api.CatApi
import com.example.insystems.di.qualifiers.HomeFragmentScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
class NetworkModule {
    @Provides
    @HomeFragmentScope
    fun getApiInterface(retroFit: Retrofit): CatApi =
        retroFit.create(CatApi::class.java)

    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient?, converter: Converter.Factory): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converter)
        okHttpClient?.let {
            builder.client(it)
        }

        return builder.build()
    }

    @Provides
    fun getOkHttpClient(): OkHttpClient? {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    fun getConverterFactory(): Converter.Factory = MoshiConverterFactory.create()


    companion object {
        const val BASE_URL = "https://api.thecatapi.com/"
    }
}