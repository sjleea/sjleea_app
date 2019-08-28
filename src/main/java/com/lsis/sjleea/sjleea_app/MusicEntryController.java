package com.lsis.sjleea.sjleea_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicEntryController {
    private MusicEntryRepository repository;

    public MusicEntryController()
    {

    }

    public MusicEntryController(MusicEntryRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<MusicEntry>> list()
    {
        return new ResponseEntity<List<MusicEntry>>(repository.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MusicEntry> create(@RequestBody MusicEntry entry)
    {
        MusicEntry newEntry = repository.create(entry);

        return new ResponseEntity<>(newEntry, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@PathVariable("id") long entryId, @RequestBody MusicEntry entry)
    {
        MusicEntry musicEntry = repository.update(entryId, entry);

        if(musicEntry == null)
        {
            return new ResponseEntity(musicEntry, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(musicEntry, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable("id") long entryId)
    {
        repository.delete(entryId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
