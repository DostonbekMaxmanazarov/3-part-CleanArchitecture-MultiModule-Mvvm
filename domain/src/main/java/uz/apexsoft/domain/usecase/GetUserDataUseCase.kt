package uz.apexsoft.domain.usecase

import uz.apexsoft.domain.models.UserData

interface GetUserDataUseCase {
    operator fun invoke(): UserData
}