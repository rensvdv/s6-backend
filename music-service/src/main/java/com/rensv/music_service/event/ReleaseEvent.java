package com.rensv.music_service.event;

import java.time.Instant;

public record ReleaseEvent(
        String songId,
        String artistId,
        String title,
        String releasedAt
) {}
