package com.rensv.rec_service.controller;

import com.rensv.rec_service.model.Recommendation;
import com.rensv.rec_service.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationRepository repository;

    @GetMapping("/release-radar")
    public List<Recommendation> getRecommendations() {
        return repository.findAll();
    }
}
