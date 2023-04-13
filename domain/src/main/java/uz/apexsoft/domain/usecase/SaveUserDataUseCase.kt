package uz.apexsoft.domain.usecase

import uz.apexsoft.domain.models.SaveUserDataParam

interface SaveUserDataUseCase {
    operator fun invoke(param: SaveUserDataParam): Boolean
}