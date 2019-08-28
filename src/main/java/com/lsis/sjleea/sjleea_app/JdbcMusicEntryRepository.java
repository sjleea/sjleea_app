package com.lsis.sjleea.sjleea_app;

import java.util.List;

public class JdbcMusicEntryRepository implements  MusicEntryRepository{
    private MusicEntryRepository repository;

    private Long id = 0L;

    @Override
    public MusicEntry create(MusicEntry entry) {
        return null;
    }

    @Override
    public MusicEntry find(Long id) {
        return null;
    }

    @Override
    public List<MusicEntry> list() {
        return null;
    }

    @Override
    public MusicEntry update(Long id, MusicEntry entry) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
