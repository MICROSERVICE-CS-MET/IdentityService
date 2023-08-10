package com.met.identityservice.client.dto.response

import java.util.*

data class CustomerResponse(
    val id: UUID,
    var firstName: String,
    var lastName: String,
    var username: String,
    var password: String,
    var mail: String
)
