package com.example.KafkaDemo.listener;

import com.example.KafkaDemo.model.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics="Kafka_Example", groupId="group_id")
    public void consume(String message)
    {
        System.out.println("Consumed message:"+message);
    }


}
