package com.met.identityservice.client

import com.met.identityservice.client.dto.response.CustomerResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Component
@FeignClient(value = "customer-service")
interface CustomerServiceClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/customers"])
    suspend fun getAll(): List<CustomerResponse>
}
