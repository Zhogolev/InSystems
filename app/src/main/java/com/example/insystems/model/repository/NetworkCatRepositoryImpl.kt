package com.example.insystems.model.repository

import com.example.insystems.model.network.api.CatApi
import com.example.insystems.model.repository.domain.Cat
import com.example.insystems.model.repository.domain.CatDomain
import com.example.insystems.model.utils.Order
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


class NetworkCatRepositoryImpl @Inject constructor(var catsService: CatApi) : NetworkCatRepository {
    /**
     * return value regarding normal pagination (page: ..., onPage:...)
     */
    override fun getCatsList(page: Int, limit: Int, order: Order): Observable<CatDomain> =
        catsService.getCatsList(page, limit, order)
            .map { list ->
                CatDomain(
                    page,
                    list.map { catDomain -> Cat(catDomain.id, catDomain.url) })
            }

}