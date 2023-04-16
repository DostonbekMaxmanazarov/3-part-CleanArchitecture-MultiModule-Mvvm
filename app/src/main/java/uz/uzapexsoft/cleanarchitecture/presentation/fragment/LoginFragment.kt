package uz.uzapexsoft.cleanarchitecture.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import uz.uzapexsoft.cleanarchitecture.R
import uz.uzapexsoft.cleanarchitecture.databinding.FragmentLoginBinding
import uz.uzapexsoft.cleanarchitecture.presentation.vm.LoginViewModel
import uz.uzapexsoft.cleanarchitecture.presentation.vm.factory.LoginViewModelFactory

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var vm: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentLoginBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, LoginViewModelFactory(requireContext()))[LoginViewModel::class.java]
        initClickView()
        observeData()
    }

    private fun initClickView() = binding.apply {
        btnLogin.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString()
            val password = etPassword.text.toString()
            vm.login(phoneNumber = phoneNumber, password = password)
        }
    }

    private fun observeData() {
        vm.resultLiveData.observe(viewLifecycleOwner) { success ->
            binding.tvSuccess.text = success.toString()
            if (success) Toast.makeText(requireContext(), R.string.success, Toast.LENGTH_SHORT).show()
            else Toast.makeText(requireContext(), R.string.failed, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
