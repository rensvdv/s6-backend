package com.rensv.music_service.service;

import com.rensv.music_service.model.Song;
import com.rensv.music_service.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    @Autowired
    private final SongRepository songRepository;
    @Autowired
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    @Autowired
    private final KafkaTemplate<String, Song> jsonKafkaTemplate;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public void addSong(Song song) {
        Song savedSong = songRepository.save(song);
        Song copy = new Song();
        copy.setId(savedSong.getId());
        copy.setTitle(savedSong.getTitle());
        copy.setArtist(savedSong.getArtist());
        copy.setReleaseDate(savedSong.getReleaseDate());
        jsonKafkaTemplate.send("music.new-releases", copy);

    }

    public void messageTest(String topic, String message) {
        stringKafkaTemplate.send(topic, message);
    }


}
