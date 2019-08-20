package com.stackroute.rabbitproducer.service;

import com.stackroute.rabbitproducer.domain.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    private RabbitTemplate amqpTemplate;

    public Sender() {
    }

    @Autowired
    public Sender(RabbitTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company) {
        amqpTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}
