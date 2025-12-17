package com.rensv.rec_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    private Long id;
    private String songTitle;
    private String artist;
    private String genre;
}
