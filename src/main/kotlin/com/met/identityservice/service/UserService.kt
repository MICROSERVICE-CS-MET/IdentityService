package com.met.identityservice.service

import com.met.identityservice.client.dto.request.LoginRequest
import com.met.identityservice.client.dto.request.RegisterRequest
import com.met.identityservice.client.dto.response.CustomerResponse
import com.met.identityservice.client.dto.response.LoginResponse
import com.met.identityservice.client.service.CustomerServiceClient
import org.springframework.stereotype.Service

@Service
class UserService(
    private val customerClient: CustomerServiceClient
) {

    fun register(request: RegisterRequest): CustomerResponse {
        return customerClient.register(request)
    }

    fun findByLoginRequest(loginRequest: LoginRequest): LoginResponse {
        return customerClient.login(loginRequest)
    }
}
