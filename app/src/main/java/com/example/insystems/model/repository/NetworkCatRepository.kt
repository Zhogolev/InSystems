package com.example.insystems.model.repository

import com.example.insystems.model.repository.domain.CatDomain
import com.example.insystems.model.utils.Order
import io.reactivex.Observable

interface NetworkCatRepository {
    fun getCatsList(page: Int = 1, limit: Int = 10, order: Order = Order.ASC): Observable<CatDomain>
}