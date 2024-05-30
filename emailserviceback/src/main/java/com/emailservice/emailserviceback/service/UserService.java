package com.emailservice.emailserviceback.service;

import com.emailservice.emailserviceback.model.EmailUser;
import com.emailservice.emailserviceback.repo.UserRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService implements UserServiceInterface{

    private final UserRepo userRepo;
    @Override
    public EmailUser login(String email, String password) {

        EmailUser user = userRepo.findByEmail(email);
        if(user==null)return null;
        if(user.getPassword().equals(password)){
            return user;
        }else {
            return null;
        }

    }


}
