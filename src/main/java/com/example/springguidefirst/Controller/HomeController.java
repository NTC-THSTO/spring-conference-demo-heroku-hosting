package com.example.springguidefirst.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin( originPatterns = "*", maxAge = 3600, allowCredentials = "true")

@RestController
@RequestMapping("/api")
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    public ResponseEntity<Map> getStatus()
    {
        Map<String, String> map = new HashMap<>();
        map.put("app-version", appVersion);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
