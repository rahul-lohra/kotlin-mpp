package com.rahullohra.di.modules

import com.rahullohra.datasource.ApiClient
import com.rahullohra.repositories.FlickrRepository
import com.rahullohra.usecase.GetPhotosUseCase
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideUseCase(flickrRepository: FlickrRepository): GetPhotosUseCase {
        return GetPhotosUseCase(flickrRepository)
    }

    @Provides
    fun provideUseRepository(apiClient: ApiClient): FlickrRepository {
        return FlickrRepository(apiClient)
    }
}