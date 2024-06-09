package com.emailservice.emailserviceback.repo;

import com.emailservice.emailserviceback.model.Email;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;

public interface EmailRepo extends JpaRepository<Email, Long> {

    Collection<Email> findBySender(String sender);
    Collection<Email> findByReciver(String reciver);
    Email findByTimestamp(LocalDateTime timestamp);
}
