package com.emailservice.emailserviceback.service;

import com.emailservice.emailserviceback.model.Email;

import java.util.Collection;

public interface EmailServiceInterface {

    Collection<Email> list();
    Email create(Email email);
}
