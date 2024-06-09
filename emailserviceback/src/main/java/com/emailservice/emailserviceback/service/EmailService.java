package com.emailservice.emailserviceback.service;

import com.emailservice.emailserviceback.model.Email;
import com.emailservice.emailserviceback.repo.EmailRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class EmailService implements EmailServiceInterface {

    private final EmailRepo emailRepo;

    @Override
    public Collection<Email> list() {

        return emailRepo.findAll().stream().toList();
    }

    @Override
    public Collection<Email> getRecived(String reciver) {

        return emailRepo.findByReciver(reciver);
    }

    @Override
    public Collection<Email> getSent(String sender) {
        return emailRepo.findBySender(sender);
    }

    @Override
    public Boolean deleteEmail(Long id) {
        emailRepo.deleteById(id);
        return true;
    }

    @Override
    public Email create(Email email) {
        return emailRepo.save(email);
    }
}
