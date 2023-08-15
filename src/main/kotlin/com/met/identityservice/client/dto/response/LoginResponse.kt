package com.met.identityservice.client.dto.response

import java.util.UUID

data class LoginResponse(
    val id: UUID?,
    var fullName: String,
    var password: String,
    var email: String
)
