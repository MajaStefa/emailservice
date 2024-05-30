package com.emailservice.emailserviceback.resource;

import com.emailservice.emailserviceback.model.EmailUser;
import com.emailservice.emailserviceback.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<EmailUser> saveServer(@RequestBody @Valid EmailUser user){
        EmailUser userNew = userService.login(user.getEmail(),user.getPassword());
        return ResponseEntity.ok(userNew);
    }

}
