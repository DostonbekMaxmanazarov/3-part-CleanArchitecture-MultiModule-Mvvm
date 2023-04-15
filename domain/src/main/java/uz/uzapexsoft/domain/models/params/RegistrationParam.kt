package uz.uzapexsoft.domain.models.params

data class RegistrationParam(
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val confirmPassword: String = ""
)
