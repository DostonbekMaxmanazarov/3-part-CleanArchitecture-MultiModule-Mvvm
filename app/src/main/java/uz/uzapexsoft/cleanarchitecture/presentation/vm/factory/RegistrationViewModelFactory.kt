package uz.uzapexsoft.cleanarchitecture.presentation.vm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.uzapexsoft.cleanarchitecture.presentation.vm.RegistrationViewModel
import uz.uzapexsoft.data.mapper.impl.AuthenticationRequestMapToDomain
import uz.uzapexsoft.data.mapper.impl.SaveAuthenticationParamMapToStorage
import uz.uzapexsoft.data.repository.AuthRepositoryImpl
import uz.uzapexsoft.data.storage.AuthStorage
import uz.uzapexsoft.data.storage.impl.AuthStorageSharedPrefImpl
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import uz.uzapexsoft.domain.usecase.impl.SaveAuthUseCaseImpl

class RegistrationViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val authStorage: AuthStorage by lazy(LazyThreadSafetyMode.NONE) {
        AuthStorageSharedPrefImpl(context = context)
    }

    private val saveAuthParamMapToStorage = SaveAuthenticationParamMapToStorage()
    private val authRequestMapToDomain = AuthenticationRequestMapToDomain()

    private val authRepository: AuthRepository by lazy(LazyThreadSafetyMode.NONE) {
        AuthRepositoryImpl(authStorage = authStorage, saveAuthParamMapToStorage = saveAuthParamMapToStorage, authRequestMapToDomain = authRequestMapToDomain)
    }

    private val saveAuthUseCase: SaveAuthUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveAuthUseCaseImpl(authRepository = authRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistrationViewModel(saveAuthUseCase = saveAuthUseCase) as T
    }
}