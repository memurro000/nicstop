package com.murro.nicstop.repository;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;
import java.util.List;

public interface SignerRepo {

    public List<UserSigner> findAllSigners();
    
    public UserSignToken saveSigner(UserSigner signer, int key);

    public UserSigner findById(int id);
    
    public String updateSigner(UserSigner signer, int key);
    
    public String deleteSigner(int id, int key);
}

