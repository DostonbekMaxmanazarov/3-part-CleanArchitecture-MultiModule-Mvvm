package uz.uzapexsoft.cleanarchitecture.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import uz.uzapexsoft.cleanarchitecture.R
import uz.uzapexsoft.cleanarchitecture.databinding.FragmentRegistrationBinding
import uz.uzapexsoft.cleanarchitecture.presentation.utils.extensions.replaceFragment
import uz.uzapexsoft.data.mapper.impl.AuthenticationRequestMapToDomain
import uz.uzapexsoft.data.mapper.impl.SaveAuthenticationParamMapToStorage
import uz.uzapexsoft.data.repository.AuthRepositoryImpl
import uz.uzapexsoft.data.storage.AuthStorageSharedPref
import uz.uzapexsoft.data.storage.impl.AuthStorageSharedPrefImpl
import uz.uzapexsoft.domain.models.RegistrationParam
import uz.uzapexsoft.domain.repository.AuthRepository
import uz.uzapexsoft.domain.usecase.SaveAuthUseCase
import uz.uzapexsoft.domain.usecase.impl.SaveAuthUseCaseImpl

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val authStorage: AuthStorageSharedPref by lazy(LazyThreadSafetyMode.NONE) {
        AuthStorageSharedPrefImpl(context = requireContext())
    }

    private val saveAuthParamMapToStorage = SaveAuthenticationParamMapToStorage()
    private val authRequestMapToDomain = AuthenticationRequestMapToDomain()

    private val authRepository: AuthRepository by lazy(LazyThreadSafetyMode.NONE) {
        AuthRepositoryImpl(authStorage = authStorage, saveAuthParamMapToStorage = saveAuthParamMapToStorage, authRequestMapToDomain = authRequestMapToDomain)
    }

    private val saveAuthUseCase: SaveAuthUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveAuthUseCaseImpl(authRepository = authRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentRegistrationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() = binding.apply {
        btnSaveData.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            val registrationParams = RegistrationParam(
                email = email,
                password = password,
                phoneNumber = phoneNumber,
                confirmPassword = confirmPassword
            )
            val success = saveAuthUseCase(param = registrationParams)
            if (success) Toast.makeText(requireContext(), R.string.success, Toast.LENGTH_SHORT).show()
            else Toast.makeText(requireContext(), R.string.failed, Toast.LENGTH_SHORT).show()
        }

        tvLogin.setOnClickListener {
            replaceFragment(container = R.id.container, fragment = LoginFragment(), addToBackStack = true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}