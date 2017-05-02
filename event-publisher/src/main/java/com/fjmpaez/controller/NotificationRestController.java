package com.fjmpaez.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fjmpaez.queuing.Gateway;
import com.fjmpaez.queuing.pojo.Event;

@RestController
@RequestMapping(path = "/v1.0")
public class NotificationRestController {

    private static Logger logger = LoggerFactory.getLogger(NotificationRestController.class);

    @Autowired
    private Gateway gateway;


    @RequestMapping(path = "/events", method = RequestMethod.POST)
    public String events(@RequestBody Event request) {

        logger.info("Event received: {}", request);

        String routingKey = "events.operator." + request.getEventType();

        gateway.send(request, routingKey);
        logger.info("Publishing to RabbitMQ. RoutingKey: {}; Event: {}", routingKey, request);

        return "ok";
    }

}
