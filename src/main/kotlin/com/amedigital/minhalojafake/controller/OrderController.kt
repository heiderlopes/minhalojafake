package com.amedigital.minhalojafake.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api/order")
class OrderController {

    @PostMapping()
    fun create(response: HttpServletResponse): String {
        val random = Random()
        random.nextInt(9999999)
        val orderId = random.nextLong().toString() + "-02"
        response.addHeader("Location", orderId)
        response.addHeader("X-Deep-Link", "fake://order?id=$orderId")
        return "OK"
    }
}