package com.emailservice.emailserviceback.resource;

import com.emailservice.emailserviceback.model.Email;
import com.emailservice.emailserviceback.model.EmailUser;
import com.emailservice.emailserviceback.service.EmailService;
import com.emailservice.emailserviceback.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailResource {
    private final EmailService emailService;
    @GetMapping("/getAll")
    public ResponseEntity<Collection<Email>> saveServer(){

        return ResponseEntity.ok(emailService.list());
    }

    
}
