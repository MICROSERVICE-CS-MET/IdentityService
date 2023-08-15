package com.met.identityservice.client.dto.request

data class LoginRequest(
    val email: String,
    val password: String
)
