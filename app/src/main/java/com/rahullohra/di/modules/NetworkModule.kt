package com.rahullohra.di.modules

import com.rahullohra.datasource.ApiClient
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideApiClient(): ApiClient {
        return ApiClient
    }
}