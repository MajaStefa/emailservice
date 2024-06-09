package com.emailservice.emailserviceback.service;

import com.emailservice.emailserviceback.model.Email;

import java.util.Collection;

public interface EmailServiceInterface {

    Collection<Email> list();
    Collection<Email> getRecived(String reciver);

    Collection<Email> getSent(String sender);

    Boolean deleteEmail(Long id);
    Email create(Email email);
}
