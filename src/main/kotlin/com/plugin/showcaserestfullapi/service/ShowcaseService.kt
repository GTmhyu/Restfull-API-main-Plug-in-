package com.plugin.showcaserestfullapi.service

import com.plugin.showcaserestfullapi.model.CreateShowcaseRequest
import com.plugin.showcaserestfullapi.model.ListShowcaseRequest
import com.plugin.showcaserestfullapi.model.ShowcaseResponse

interface ShowcaseService {
    fun create(createShowcaseRequest: CreateShowcaseRequest) : ShowcaseResponse
    fun get(id: Int) : ShowcaseResponse
    fun list(listShowcaseRequest: ListShowcaseRequest) : List<ShowcaseResponse>
    fun delete(id: Int)
    fun put(id: Int, updateShowcaseRequest: CreateShowcaseRequest) : ShowcaseResponse
}