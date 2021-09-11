package com.ragabz.data.di

import com.ragabz.data.repositoriesImpl.DocumentRepositoryImpl
import com.ragabz.data.source.remote.DocumentApi
import com.ragabz.domain.repositories.IDocumentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDocumentRepository(documentApi: DocumentApi): IDocumentRepository {
        return DocumentRepositoryImpl(documentApi)
    }

}