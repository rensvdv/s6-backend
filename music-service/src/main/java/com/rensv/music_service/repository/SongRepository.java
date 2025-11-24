package com.rensv.music_service.repository;
import com.rensv.music_service.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {}
