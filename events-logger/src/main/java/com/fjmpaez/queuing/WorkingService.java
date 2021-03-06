package com.fjmpaez.queuing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.fjmpaez.queuing.pojo.Event;

@Service
public class WorkingService {

    private static Logger logger = LoggerFactory.getLogger(WorkingService.class);

    public void processEventFromQueue(Event event,
            @Header(name = AmqpHeaders.RECEIVED_ROUTING_KEY) String receivedRoutingKey,
            @Header(name = AmqpHeaders.RECEIVED_DELAY, required = false) Integer currentDelay,
            @Header(name = AmqpHeaders.CONSUMER_QUEUE) String consumerQueue) {

        logger.info("Event received from queue. Event: {}; Queue: {}", event, consumerQueue);

    }

}
