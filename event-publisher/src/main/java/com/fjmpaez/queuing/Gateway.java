package com.fjmpaez.queuing;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import com.fjmpaez.queuing.pojo.Event;

public interface Gateway {

    void send(@Payload Event event, @Header("routingKey") String routingKey);

}
