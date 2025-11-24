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
    private final KafkaTemplate<String, Song> kafkaTemplate;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public void addSong(Song song) {
        Song saved = songRepository.save(song);
        kafkaTemplate.send("music.new-releases", saved.getArtist(), saved);

    }
}
