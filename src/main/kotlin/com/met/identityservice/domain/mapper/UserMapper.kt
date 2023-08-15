package com.met.identityservice.domain.mapper

import com.met.identityservice.client.dto.response.CustomerResponse
import com.met.identityservice.domain.model.User

interface UserMapper {

    fun customersToCustomerResponses(user: List<User>): List<CustomerResponse>
}
