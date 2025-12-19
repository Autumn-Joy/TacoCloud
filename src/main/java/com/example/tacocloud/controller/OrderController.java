package com.example.tacocloud.controller;

import com.example.tacocloud.domain.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(TacoOrder order, SessionStatus sessionStatus) {
        // add persistence here when db gets connected
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect: /";
    }

}


/*
 * using Lombok's `@Slf4j` annotation to create a free
 * SLF4J `Logger` object at compile time
 *
 * the class-level `@RequestMapping` specifies that any
 * request-handling methods in this controller will handle
 * requests with the path `/orders`.
 *
 * the method-level `@GetMapping` specifies that the `orderForm()` method
 * will handle `GET` requests for `/orders/current`.
 *
 * for now, the `orderForm()` method only returns the view name
 * as we have not yet set up a database for persistence
 *
 * once a database is set up, `orderForm()` method will be refactored
 * to populate the model with a list of `Taco` objects
 * that will be placed in the order
 *
 */