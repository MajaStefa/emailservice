package com.emailservice.emailserviceback.service;

import com.emailservice.emailserviceback.model.EmailUser;

public interface UserServiceInterface {


    EmailUser login(String email, String password);
}
