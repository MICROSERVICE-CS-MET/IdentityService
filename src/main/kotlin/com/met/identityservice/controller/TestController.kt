package com.met.identityservice.controller

import com.met.identityservice.client.CustomerServiceClient
import com.met.identityservice.client.dto.response.CustomerResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController(
    private val customerServiceClient: CustomerServiceClient
) {
    @GetMapping("/all-users")
    fun getAll(): List<CustomerResponse> {
        return customerServiceClient.all()
    }

    @GetMapping("/test")
    fun test(): String {
        return customerServiceClient.test()
    }
}
