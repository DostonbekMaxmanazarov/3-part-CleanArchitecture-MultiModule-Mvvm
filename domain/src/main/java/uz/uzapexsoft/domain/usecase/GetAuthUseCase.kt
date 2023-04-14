package uz.uzapexsoft.domain.usecase

import uz.uzapexsoft.domain.models.LoginParam

interface GetAuthUseCase {
    operator fun invoke(param: LoginParam): Boolean
}