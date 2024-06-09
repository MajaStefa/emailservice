package com.emailservice.emailserviceback.repo;

import com.emailservice.emailserviceback.model.Email;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface EmailRepo extends JpaRepository<Email, Long> {

    Email findBySender(String sender);
    Email findByReciver(String reciver);
    Email findByTimestamp(LocalDateTime timestamp);
}
