package uz.apexsoft.domain.repository

import uz.apexsoft.domain.models.SaveUserDataParam
import uz.apexsoft.domain.models.UserData

interface UserRepository {
    fun saveUserData(saveParam: SaveUserDataParam): Boolean
    fun getUserData(): UserData
}