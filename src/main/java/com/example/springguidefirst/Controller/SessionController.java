package com.example.springguidefirst.Controller;

import com.example.springguidefirst.Model.Session;
import com.example.springguidefirst.Repository.SessionRepository;
import com.example.springguidefirst.Service.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( originPatterns = "*", maxAge = 3600, allowCredentials = "true")

@RestController
@RequestMapping("/Sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions()
    {
        List<Session> Sessions = sessionRepository.findAll();
        return new ResponseEntity<>(Sessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSession(@PathVariable("id") Long id)
    {
        Session session = sessionRepository.getOne(id);
        if (session != null){
            return new ResponseEntity<>(session, HttpStatus.OK);
        }
        return new ResponseEntity<>(session, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Session> addSession(@RequestBody final Session session)
    {
        Session newSession = sessionRepository.saveAndFlush(session);
        return new ResponseEntity<>(newSession, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Session> updateSession(@RequestBody Session session)
    {
        Session attempt = sessionRepository.getOne(session.getId());
        BeanUtils.copyProperties(session, attempt, "session_id");
        return new ResponseEntity<>(sessionRepository.saveAndFlush(attempt), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSession(@PathVariable("id") Long id)
    {
        sessionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
