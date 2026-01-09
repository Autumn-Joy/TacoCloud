package com.example.tacocloud.controller;

import com.example.tacocloud.domain.TacoOrder;
import com.example.tacocloud.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            log.error("errors occured: {}", errors.getAllErrors());
            return "orderForm";
        }


        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
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