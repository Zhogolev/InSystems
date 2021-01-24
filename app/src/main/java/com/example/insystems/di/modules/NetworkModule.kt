package com.example.insystems.di.modules

import android.content.Context
import com.example.insystems.model.network.api.CatApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun getApiInterface(retroFit: Retrofit): CatApi =
        retroFit.create(CatApi::class.java)


    @Provides
    fun getRetrofit(
        okHttpClient: OkHttpClient,
        converter: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory
    ): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converter)
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClient)
        return builder.build()
    }

    @Provides
    fun getOkHttpClient(
        interceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .cache(cache)
            .build()
    }

    @Provides
    fun getLogger(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun getCache(applicationContext: Context) = Cache(applicationContext.cacheDir, 1024 * 1024 * 10)

    @Provides
    fun getCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory
        .createWithScheduler(Schedulers.io())

    @Provides
    fun getConverterFactory(): Converter.Factory = MoshiConverterFactory.create()


    companion object {
        const val BASE_URL = "https://api.thecatapi.com/"
    }
}