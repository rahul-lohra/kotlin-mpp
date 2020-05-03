package com.rahullohra.repositories

import com.rahullohra.datasource.ApiClient
import com.rahullohra.datasource.Constants
import kotlin.collections.set

class FlickrRepository(val apiClient: ApiClient) {

    suspend fun searchPhotos(text: String, page: Int, perPage: String = Constants.DEFAULT_PER_PAGE): String {
        val map = HashMap<String, String>()
        map[SearchParams.TEXT] = text
        map[SearchParams.PAGE] = page.toString()
        map[CommonParams.API_KEY] = Constants.API_KEY
        map[CommonParams.PER_PAGE] = perPage
        val fullUrl = Constants.FLICKR_BASE_URL + Constants.SEARCH_PHOTOS_URL
        return apiClient.get(fullUrl, map)
    }
}

object SearchParams {
    const val TEXT = "text"
    const val PAGE = "page"
}

object CommonParams {
    const val API_KEY = "api_key"
    const val PER_PAGE = "per_page"
}