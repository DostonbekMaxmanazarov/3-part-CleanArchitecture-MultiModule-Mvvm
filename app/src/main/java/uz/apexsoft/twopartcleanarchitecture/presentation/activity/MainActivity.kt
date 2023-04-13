package uz.apexsoft.twopartcleanarchitecture.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.apexsoft.twopartcleanarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val userStorage: uz.apexsoft.data.storage.UserStorage by lazy(LazyThreadSafetyMode.NONE) {
        uz.apexsoft.data.storage.impl.UserStorageSharedPrefImpl(context = this)
    }
    private val userRepository: uz.apexsoft.domain.repository.UserRepository by lazy(LazyThreadSafetyMode.NONE) {
        uz.apexsoft.data.repository.UserRepositoryImpl(userStorage = userStorage)
    }
    private val getUserDataUseCase: uz.apexsoft.domain.usecase.GetUserDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        uz.apexsoft.domain.usecase.impl.GetUserDataUseCaseImpl(userRepository = userRepository)
    }
    private val saveUserDataUseCase: uz.apexsoft.domain.usecase.SaveUserDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        uz.apexsoft.domain.usecase.impl.SaveUserDataUseCaseImpl(userRepository = userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClickView()
    }

    private fun initClickView() = binding.apply {
        btnGetUserData.setOnClickListener {
            val result = getUserDataUseCase()
            tvFirstName.text = result.firstName
            tvLastName.text = result.lastName
        }

        btnSaveData.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val param = uz.apexsoft.domain.models.SaveUserDataParam(
                firstName = firstName,
                lastName = lastName
            )
            val result = saveUserDataUseCase(param = param)
            tvResult.text = "$result"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}