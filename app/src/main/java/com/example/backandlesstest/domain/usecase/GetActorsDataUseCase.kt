package com.example.backandlesstest.domain.usecase

import com.example.backandlesstest.data.repository.ActorsRepository

class GetActorsDataUseCase(private val actorsRepository: ActorsRepository) {
    suspend operator fun invoke() = actorsRepository.getActorsData()
}