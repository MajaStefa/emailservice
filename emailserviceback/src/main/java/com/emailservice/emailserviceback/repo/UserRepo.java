package com.emailservice.emailserviceback.repo;

import com.emailservice.emailserviceback.model.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<EmailUser, Long> {

    EmailUser findByEmail(String email);
}
