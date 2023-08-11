package com.met.identityservice.domain.dto

data class LoginRequest (
    val email: String,
    val password: String
)