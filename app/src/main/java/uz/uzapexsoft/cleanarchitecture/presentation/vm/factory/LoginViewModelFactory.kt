package uz.uzapexsoft.cleanarchitecture.presentation.vm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.uzapexsoft.cleanarchitecture.presentation.vm.LoginViewModel
import uz.uzapexsoft.data.mapper.impl.AuthenticationRequestMapToDomain
import uz.uzapexsoft.data.mapper.impl.SaveAuthenticationParamMapToStorage
import uz.uzapexsoft.data.repository.AuthRepositoryImpl
import uz.uzapexsoft.data.storage.AuthStorage
import uz.uzapexsoft.data.storage.impl.AuthStorageSharedPrefImpl
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.usecase.GetAuthUseCase
import uz.uzapexsoft.domain.usecase.impl.GetAuthUseCaseImpl

class LoginViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val authStorage: AuthStorage by lazy(LazyThreadSafetyMode.NONE) {
        AuthStorageSharedPrefImpl(context = context)
    }

    private val saveAuthParamMapToStorage = SaveAuthenticationParamMapToStorage()
    private val authRequestMapToDomain = AuthenticationRequestMapToDomain()

    private val authRepository: AuthRepository by lazy(LazyThreadSafetyMode.NONE) {
        AuthRepositoryImpl(
            authStorage = authStorage,
            saveAuthParamMapToStorage = saveAuthParamMapToStorage,
            authRequestMapToDomain = authRequestMapToDomain
        )
    }
    private val getAuthUseCase: GetAuthUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetAuthUseCaseImpl(authRepository = authRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(getAuthUseCase = getAuthUseCase) as T
    }
}