package com.example.springguidefirst.Repository;

import com.example.springguidefirst.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
