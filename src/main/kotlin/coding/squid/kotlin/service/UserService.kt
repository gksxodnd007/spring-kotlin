package coding.squid.kotlin.service

import coding.squid.kotlin.domain.User
import coding.squid.kotlin.dto.RegisterUserDto
import coding.squid.kotlin.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    fun registerUser(userInfo: RegisterUserDto) {
        val user: User = User(userInfo.name, userInfo.age)
        userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUserOrThrow(id: Int): User {
        return userRepository.findById(id).orElseThrow { RuntimeException("Not found user") }
    }
}