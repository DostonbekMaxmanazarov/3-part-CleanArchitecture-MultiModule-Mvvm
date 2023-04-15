package uz.uzapexsoft.data.mapper.impl

import uz.uzapexsoft.data.mapper.SingleMapper
import uz.uzapexsoft.data.storage.models.AuthenticationRequest
import uz.uzapexsoft.domain.models.params.RegistrationParam

class SaveAuthenticationParamMapToStorage : SingleMapper<RegistrationParam, AuthenticationRequest> {
    override fun invoke(value: RegistrationParam): AuthenticationRequest {
        return AuthenticationRequest(
            email = value.email,
            password = value.password,
            phoneNumber = value.phoneNumber,
        )
    }
}