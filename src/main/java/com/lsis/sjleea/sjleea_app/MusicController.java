package com.lsis.sjleea.sjleea_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/musics")
public class MusicController {

    private final MusicBean musicBean;

    public MusicController(MusicBean musicBean)
    {
        this.musicBean = musicBean;
    }
/*
    @GetMapping
    public String index(Map<String, Object> model)
    {
        model.put("musics", musicBean.getMusics());

        return "musics";
    }
*/
    @GetMapping
    public ResponseEntity<List<Music>> list()
    {
        return new ResponseEntity<List<Music>>(musicBean.getMusics(), HttpStatus.OK);
    }

    @GetMapping("/{musicId}")
    public ResponseEntity<Music> read(@PathVariable long musicId, Map<String, Object> model)
    {
        Music music = musicBean.find(musicId);

        if(music != null)
        {
            return new ResponseEntity( musicBean.find(musicId), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity( musicBean.find(musicId), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Music> create(@RequestBody Music music)
    {
        String title = music.getTitle();
        String album = music.getAlbum();
        String genre = music.getGenre();
        int year = music.getYear();
        int rating = music.getRating();

        Music entry = new Music(title, album, genre, year, rating);

        musicBean.addMusic(entry);

        return new ResponseEntity<>( entry, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Music> update(@PathVariable(name="id") long musicId, @RequestBody Music music)
    {
        if(musicBean.find(musicId) == null)
        {
            return new ResponseEntity( music, HttpStatus.NOT_FOUND);
        }
        else
        {
            musicBean.updateMusic(music);

            return new ResponseEntity( music, HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Music> update(@PathVariable(name="id") long musicId)
    {
        Music music = musicBean.find(musicId);

        if(music != null)
        {
            musicBean.deleteMusic(music);

            return new ResponseEntity( music, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity( music, HttpStatus.NOT_FOUND);
        }
    }
}
