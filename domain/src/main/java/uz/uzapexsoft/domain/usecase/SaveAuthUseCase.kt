package uz.uzapexsoft.domain.usecase

import uz.uzapexsoft.domain.models.params.RegistrationParam

interface SaveAuthUseCase {
    operator fun invoke(param: RegistrationParam): Boolean
}