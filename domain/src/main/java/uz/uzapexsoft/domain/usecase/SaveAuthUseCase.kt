package uz.uzapexsoft.domain.usecase

import uz.uzapexsoft.domain.models.RegistrationParam

interface SaveAuthUseCase {
    operator fun invoke(param: RegistrationParam): Boolean
}