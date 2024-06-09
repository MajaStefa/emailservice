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
    public ResponseEntity<Collection<Email>> getServers(){
        return ResponseEntity.ok(emailService.list());
    }

    @PostMapping("/getBySender")
    public ResponseEntity<Collection<Email>> getBySender(@RequestBody String sender){
        return ResponseEntity.ok(emailService.getRecived(sender));
    }

    @PostMapping("/getByReciver")
    public ResponseEntity<Collection<Email>> getByReciver(@RequestBody String reciver){
        return ResponseEntity.ok(emailService.getRecived(reciver));
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<Email> sendEmail(@RequestBody Email email){
        return ResponseEntity.ok(emailService.create(email));
    }

    @PostMapping("/deleteEmail")
    public ResponseEntity<Boolean> deleteEmail(@RequestBody Long id){

        return ResponseEntity.ok(emailService.deleteEmail(id));
    }



    
}
