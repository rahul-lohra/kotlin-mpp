package com.rahullohra.usecase

import com.rahullohra.repositories.FlickrRepository

class GetPhotosUseCase(val flickrRepository: FlickrRepository) {

    suspend fun searchPhotos(text: String, page: Int): String {
        return flickrRepository.searchPhotos(text, page)
    }

}