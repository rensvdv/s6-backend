package com.rensv.music_service.controller;

import com.rensv.music_service.model.Song;
import com.rensv.music_service.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public List<Song> getAll() {
        return songService.getAllSongs();
    }

    @PostMapping
    public ResponseEntity<String> addSong(@RequestBody Song song) {
        songService.addSong(song);
        return new ResponseEntity<>("Song Added", HttpStatus.CREATED);
    }

    @PostMapping("/test")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        songService.messageTest("my-topic", message);
        return ResponseEntity.ok("Message published to Kafka topic");
    }
}
