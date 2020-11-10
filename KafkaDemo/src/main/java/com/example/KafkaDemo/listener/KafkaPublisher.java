package com.example.KafkaDemo.listener;

import com.example.KafkaDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class KafkaPublisher {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    public static  final String TOPIC="Kafka_Example";
    @GetMapping(value = "/{message}")
    public String sendMessageToKafkaTopic(@PathVariable("message") String message) {
        kafkaTemplate.send(TOPIC,message);
        return "published successfully";
    }

@Autowired
KafkaTemplate<String, Employee> kafkaTemplate1;
    public static  final String TOPIC1="Kafka_Example";
    @GetMapping("/{id}/{name}/{number}/{email}")
    public String post(
            @PathVariable("id") final Integer id,
            @PathVariable("name") final String name,
            @PathVariable("number") final long number,
            @PathVariable("email") final String email)
    {

        kafkaTemplate1.send(TOPIC1, new Employee(id, name, number,email));
        return "Published successfully";
    }
}