package org.company.pipeline_architecture.controller;

import org.company.pipeline_architecture.services.rabbitmq.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/send")
    public ResponseEntity<Object> sendOrder(@RequestBody String order) {
        orderProducer.sendOrder(order);
        return new ResponseEntity<>("push-message: " + order, HttpStatus.OK);
    }
}