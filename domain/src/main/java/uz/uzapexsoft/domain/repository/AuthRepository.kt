package uz.uzapexsoft.domain.repository

import uz.uzapexsoft.domain.models.RegistrationParam
import uz.uzapexsoft.domain.models.Authentication

interface AuthRepository {
    fun saveAuthentication(saveParam: RegistrationParam): Boolean
    fun getAuthentication(): Authentication
}