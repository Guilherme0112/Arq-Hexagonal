package com.messaging.messaging.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CompraListener {

  @KafkaListener(topics = "produto-salvo-topic", groupId = "produto-group")
  public void compraRealizada(String msg) {
    System.out.println("Mensagem: " + msg);
  }
}
