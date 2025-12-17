package com.rensv.rec_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class SongReleaseListener {

    @KafkaListener(topics = "music.new-releases", groupId = "rec-service-group")
    public void listen(String song) {
        System.out.println("Received Message: " + song);
    }

    @KafkaListener(topics = "my-topic", groupId = "rec-service-group")
    public void listenTest(String message) {
        System.out.println("Received Message: " + message);
    }
}
