package com.example.insystems.model.network.api

import com.example.insystems.model.network.model.CatDto
import com.example.insystems.model.utils.Order
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface CatApi {
    @GET("v1/images/search")
    fun getCatsList(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("order") order: Order = Order.DESC
    ): Observable<List<CatDto>>
}