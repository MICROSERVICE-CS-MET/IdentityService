package com.met.identityservice.client.service

import com.met.identityservice.client.dto.request.LoginRequest
import com.met.identityservice.client.dto.request.RegisterRequest
import com.met.identityservice.client.dto.response.CustomerResponse
import com.met.identityservice.client.dto.response.LoginResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Component
@FeignClient(value = "customer-service", url = "http://localhost:6060/customers")
interface CustomerServiceClient {

    @PostMapping("/validate-user")
    fun login(loginRequest: LoginRequest): LoginResponse

    @PostMapping("/register")
    fun register(registerRequest: RegisterRequest): CustomerResponse

    @GetMapping("/find-by-email/{email}")
    fun findByEmail(@PathVariable("email") email: String): CustomerResponse?
}
