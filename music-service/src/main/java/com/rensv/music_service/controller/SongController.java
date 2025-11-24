package com.rensv.music_service.controller;

import com.rensv.music_service.model.Song;
import com.rensv.music_service.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping()
    public ResponseEntity<String> addAlbum(@RequestBody Song song) {
        songService.addSong(song);
        System.out.println(" - Artiest: " + song.getArtist());
        System.out.println(" - Releasedate: " + song.getArtist());
        return new ResponseEntity<>("Song Added", HttpStatus.CREATED);
    }
}
