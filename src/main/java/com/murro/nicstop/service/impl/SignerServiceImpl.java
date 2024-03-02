package com.murro.nicstop.service.impl;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.stereotype.Service;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignTokenRepo;
import com.murro.nicstop.repository.SignerRepo;
import com.murro.nicstop.service.SignerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SignerServiceImpl implements SignerService{

    private final SignerRepo signer_repo;
    private final SignTokenRepo token_repo;

    private final SecureRandom srandom = new SecureRandom();

    @Override
    public List<UserSigner> findAllSigners() {
        System.out.println(token_repo.findAll());
        return signer_repo.findAll();
    }

    @Override
    public UserSigner findById(long id) {
        System.out.println(token_repo.getReferenceById(id));
        return signer_repo.getReferenceById(id);
    }

    @Override
    public UserSigner getRandom() {
        return signer_repo.findRandomUserSignerWithCommentary();
    }

    @Override
    public UserSignToken saveSigner(UserSigner signer) {
        signer_repo.save(signer);
        return token_repo.save(new UserSignToken(srandom.nextInt()));
    }

    @Override
    public String updateSigner(UserSigner signer, int key) {
        if(token_repo.getReferenceById(signer.getId())
                .getKey().equals(key))
            return "Success! " + signer_repo.save(signer).toString();
        else
            return "Wrong key!";
    }

    @Override
    public String deleteSigner(UserSignToken token) {
        Long id = token.getId();
        if(!signer_repo.existsById(id)) 
            return "No such signer";
        
        if(token_repo.getReferenceById(id)
                .equals(token)) {
            signer_repo.deleteById(id);
            token_repo.deleteById(id);
            return "Success!";
        } 
        else {
            return "Wrong key!";
        }
    }

}
