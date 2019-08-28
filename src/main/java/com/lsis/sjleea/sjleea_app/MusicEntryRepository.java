package com.lsis.sjleea.sjleea_app;

import java.util.List;

public interface MusicEntryRepository {
    MusicEntry create(MusicEntry entry);
    MusicEntry find(Long id);
    List<MusicEntry> list();
    MusicEntry update(Long id, MusicEntry entry);
    void delete(Long id);
}
