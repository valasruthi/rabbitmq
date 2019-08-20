package com.stackroute.rabbitmqconsumer.service;

import com.stackroute.rabbitmqconsumer.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer
{
  //@RabbitListener annotations is performed by registering a RabbitListenerAnnotationBeanPostProcessor.
    @RabbitListener(queues = "${jsa.rabbitmq.queue}")
    public void message(Employee employee) {
        System.out.println("Recieved Message From RabbitMQ: " + employee);
    }
}
