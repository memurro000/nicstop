package com.murro.nicstop.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignerRepo;

@Repository
public class RelDBSignerRepo implements SignerRepo {
    
    @Override
    public List<UserSigner> findAllSigners() {
        return null;
    }
    
    @Override
    public UserSignToken saveSigner(UserSigner signer, int key) {
        return null;
    }

    @Override
    public UserSigner findById(int id) {
        return null;
    }

    @Override
    public String updateSigner(UserSigner signer, int key) {
        return null;
    }

    @Override
    public String deleteSigner(int id, int key) {
        return null;
    }
}
