package com.met.identityservice.controller

import com.met.identityservice.configuration.security.JwtTokenUtil
import com.met.identityservice.domain.dto.LoginDto
import com.met.identityservice.domain.dto.RegisterRequest
import com.met.identityservice.domain.model.User
import com.met.identityservice.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val tokenUtil: JwtTokenUtil
) {
    @GetMapping()
    fun findAll(): List<User> {
        return userService.findAll()
    }

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): User {
        return userService.save(registerRequest)
    }

    @PostMapping("/login")
    fun login(@RequestBody user: LoginDto): String {
        val loadedUser = userService.findByLoginDto(user)
        val token = tokenUtil.generateToken(loadedUser.username)
        return token
    }

    @GetMapping("/validateToken")
    fun validateToken(@RequestParam("token")token: String): Boolean {
        return tokenUtil.isTokenValid(token)
    }
}
