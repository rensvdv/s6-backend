package com.rensv.rec_service.service;

import com.rensv.rec_service.model.Song;
import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SongReleaseListener {
    @PostConstruct
    public void init() {
        System.out.println("🎧 SongReleaseListener is actief!");
    }

    @KafkaListener(topics = "music.new-releases", groupId = "rec-service-group")
    public void onNewSong(Song song) {
        System.out.println("🎧 Nieuwe release ontvangen:");
        System.out.println(" - Titel: " + song.getTitle());
        System.out.println(" - Artiest: " + song.getArtist());
        // TODO: recommendation logic
    }
}

