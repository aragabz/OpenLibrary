package com.ragabz.data.di

import com.ragabz.data.source.remote.DocumentApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    /**
     * function use injected reference from retrofit
     * to create object from [DocumentApi]
     * @param retrofit
     * @return [DocumentApi]
     */
    @Provides
    @Singleton
    fun provideDocumentApi(retrofit: Retrofit): DocumentApi {
        return retrofit.create(DocumentApi::class.java)
    }

}
