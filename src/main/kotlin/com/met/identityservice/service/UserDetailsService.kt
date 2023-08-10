package com.met.identityservice.service

import com.met.identityservice.domain.model.User
import com.met.identityservice.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDetailsService(
    private val repository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByEmail(username) ?: throw UsernameNotFoundException("$username not found")
        return User(
            user.id,
            user.fullName,
            user.email,
            user.password
        )
    }
}
