package com.rensv.rec_service.repository;

import com.rensv.rec_service.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {}
