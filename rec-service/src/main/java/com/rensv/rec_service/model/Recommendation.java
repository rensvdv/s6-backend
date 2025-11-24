package com.rensv.rec_service.model;

import jakarta.persistence.*;
import lombok.*;

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
