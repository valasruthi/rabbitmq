package com.stackroute.rabbitproducer.controller;

import com.stackroute.rabbitproducer.domain.Employee;
import com.stackroute.rabbitproducer.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class ProducerController {
    private Sender rabbitMQSender;

    public ProducerController() {
    }

    @Autowired
    public ProducerController(Sender rabbitMQSender) {

      this.rabbitMQSender = rabbitMQSender;
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("eName") String eName, @RequestParam("eId") String eId) {

        Employee employee = new Employee();
        employee.setEId(eId);
        employee.setEName(eName);
        rabbitMQSender.send(employee);

        return "Successfull";
    }
}
