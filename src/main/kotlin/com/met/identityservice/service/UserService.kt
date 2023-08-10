package com.met.identityservice.service

import com.met.identityservice.domain.dto.LoginDto
import com.met.identityservice.domain.dto.RegisterRequest
import com.met.identityservice.domain.model.User
import com.met.identityservice.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {
    fun save(request: RegisterRequest): User {
        val user = User(
            fullName = request.fullName,
            email = request.email,
            password = passwordEncoder.encode(request.password)
        )
        return userRepository.save(user)
    }

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findByLoginDto(loginDto: LoginDto): User {
        userRepository.findByEmail(loginDto.email)?.let { user ->
            if (passwordEncoder.matches(loginDto.password, user.password)) return user
        }
        throw RuntimeException("User Not Found")
    }
}
