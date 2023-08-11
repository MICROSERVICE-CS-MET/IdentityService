package com.met.identityservice.client

import com.met.identityservice.client.dto.response.CustomerResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping


@Component
@FeignClient(value = "customer-service", url="http://localhost:6060/customers")
interface CustomerServiceClient {

    @GetMapping
    fun all(): List<CustomerResponse>

    @GetMapping("/test")
    fun test(): String

}
