package com.met.identityservice.controller

import com.met.identityservice.client.dto.request.LoginRequest
import com.met.identityservice.client.dto.request.RegisterRequest
import com.met.identityservice.client.dto.response.CustomerResponse
import com.met.identityservice.client.service.CustomerServiceClient
import com.met.identityservice.configuration.security.JwtTokenUtil
import com.met.identityservice.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): String {
        val user = userService.findByLoginRequest(loginRequest)
        val token = tokenUtil.generateToken(user.email)
        return token
    }

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): CustomerResponse {
        return userService.register(registerRequest)
    }

    @GetMapping("/validate-token")
    fun validateToken(@RequestParam("token")token: String): Boolean {
        return tokenUtil.isTokenValid(token)
    }
}
