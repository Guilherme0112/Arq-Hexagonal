package com.messaging.messaging.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoListener {

    @KafkaListener(topics = "pedido-salvo-topic", groupId = "messaging-group")
    public void pedidoEfetuado(String msg){
        System.out.println("Pedido efetuado: " + msg);
    }
}
