package uz.uzapexsoft.data.storage

import uz.uzapexsoft.data.storage.models.AuthenticationRequest

interface AuthStorageSharedPref {
    fun saveAuthentication(user: AuthenticationRequest): Boolean
    fun getAuthentication(): AuthenticationRequest
}