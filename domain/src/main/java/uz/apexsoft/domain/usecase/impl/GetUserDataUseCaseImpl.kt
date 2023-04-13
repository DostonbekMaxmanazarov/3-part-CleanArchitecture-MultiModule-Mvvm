package uz.apexsoft.domain.usecase.impl

import uz.apexsoft.domain.models.UserData
import uz.apexsoft.domain.repository.UserRepository
import uz.apexsoft.domain.usecase.GetUserDataUseCase

class GetUserDataUseCaseImpl(
    private val userRepository: UserRepository
) : GetUserDataUseCase {
    override fun invoke(): UserData {
        return userRepository.getUserData()
    }
}