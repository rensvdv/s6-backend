package com.rensv.music_service.service;

import com.rensv.music_service.model.Song;
import com.rensv.music_service.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
//    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final KafkaTemplate<String, Song> jsonKafkaTemplate;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public void addSong(Song song) {
        Song savedSong = songRepository.save(song);
        String artist = savedSong.getArtist();
        jsonKafkaTemplate.send("music.new-releases", savedSong);

    }

    public void messageTest(String topic, String message) {
        stringKafkaTemplate.send(topic, message);
    }


}
