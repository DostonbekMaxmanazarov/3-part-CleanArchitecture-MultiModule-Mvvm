package uz.uzapexsoft.domain.usecase

import uz.uzapexsoft.domain.models.params.LoginParam

interface GetAuthUseCase {
    operator fun invoke(param: LoginParam): Boolean
}