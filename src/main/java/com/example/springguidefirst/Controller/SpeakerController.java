package com.example.springguidefirst.Controller;
import com.example.springguidefirst.Model.Speaker;
import com.example.springguidefirst.Repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( originPatterns = "*", maxAge = 3600, allowCredentials = "true")

@RestController
@RequestMapping("/Speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public ResponseEntity<List<Speaker>> getAllSpeakers()
    {
        List<Speaker> Speakers = speakerRepository.findAll();
        return new ResponseEntity<>(Speakers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speaker> getSpeaker(@PathVariable("id") Long id)
    {
        Speaker speaker = speakerRepository.getOne(id);
        if (speaker != null){
            return new ResponseEntity<>(speaker, HttpStatus.OK);
        }
        return new ResponseEntity<>(speaker, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<Speaker> addSpeaker(@RequestBody final Speaker speaker)
    {
        Speaker newSpeaker = speakerRepository.saveAndFlush(speaker);
        return new ResponseEntity<>(newSpeaker, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Speaker> updateSession(@RequestBody Speaker speaker)
    {
        Speaker attempt = speakerRepository.getOne(speaker.getId());
        BeanUtils.copyProperties(speaker, attempt, "session_id");
        return new ResponseEntity<>(speakerRepository.saveAndFlush(attempt), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSpeaker(@PathVariable("id") Long id)
    {
        speakerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
