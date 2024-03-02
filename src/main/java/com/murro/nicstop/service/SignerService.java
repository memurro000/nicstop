package com.murro.nicstop.service;

import java.util.List;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;

public interface SignerService {

    public List<UserSigner> findAllSigners();

    public UserSigner getRandom();

    public UserSignToken saveSigner(UserSigner signer);

    public UserSigner findById(long id);

    public String updateSigner(UserSigner signer, int key);

    public String deleteSigner(UserSignToken token);


}
