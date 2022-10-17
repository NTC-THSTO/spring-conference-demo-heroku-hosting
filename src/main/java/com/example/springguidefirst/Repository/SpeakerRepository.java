package com.example.springguidefirst.Repository;

import com.example.springguidefirst.Model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}