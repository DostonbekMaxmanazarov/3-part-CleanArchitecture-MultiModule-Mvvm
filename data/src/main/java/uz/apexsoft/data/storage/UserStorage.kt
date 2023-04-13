package uz.apexsoft.data.storage

import uz.apexsoft.data.storage.models.User

interface UserStorage {
    fun saveUser(user: User): Boolean
    fun getUser(): User
}