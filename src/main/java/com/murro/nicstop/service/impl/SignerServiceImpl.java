package com.murro.nicstop.service.impl;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Service;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignerRepo;
import com.murro.nicstop.service.SignerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SignerServiceImpl implements SignerService{

    private final SignerRepo repository;
    private final SecureRandom srandom = new SecureRandom();

    @Override
    public List<UserSigner> findAllSigners() {
        return repository.findAllSigners();
    }

    @Override
    public UserSigner findById(int id) {
        return repository.findById(id);
    }

    @Override
    public UserSignToken saveSigner(UserSigner signer) {
        return repository.saveSigner(signer, srandom.nextInt());
    }

    @Override
    public String updateSigner(UserSigner signer, int key) {
        return repository.updateSigner(signer, key);
    }

    @Override
    public String deleteSigner(UserSignToken token) {
        return repository.deleteSigner(token.getId(), token.getKey());
    }
    
}
