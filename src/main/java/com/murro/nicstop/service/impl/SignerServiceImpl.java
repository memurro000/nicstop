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

    private final SignerRepo signerRepo;
    private final SignTokenRepo tokenRepo;

    private final SecureRandom srandom = new SecureRandom();

    @Override
    public List<UserSigner> findAllSigners() {
        System.out.println(tokenRepo.findAll());
        return signerRepo.findAll();
    }

    @Override
    public UserSigner findById(long id) {
        System.out.println(tokenRepo.getReferenceById(id));
        return signerRepo.getReferenceById(id);
    }

    @Override
    public UserSigner getRandom() {
        return signerRepo.findRandomUserSignerWithCommentary();
    }

    @Override
    public UserSignToken saveSigner(UserSigner signer) {
        signerRepo.save(signer);
        return tokenRepo.save(new UserSignToken(srandom.nextInt()));
    }

    @Override
    public String updateSigner(UserSigner signer, int key) {
        Long id = signer.getId(); 

        if(!signerRepo.existsById(id)) 
            return "No such signer";
        
        if(tokenRepo.getReferenceById(id)
                .getKey().equals(key))
            return "Success! " + signerRepo.save(signer).toString();
        else
            return "Wrong key!";
    }

    @Override
    public String deleteSigner(UserSignToken token) {
        Long id = token.getId();
        if(!signerRepo.existsById(id)) 
            return "No such signer";
        
        if(tokenRepo.getReferenceById(id)
                .equals(token)) {
            signerRepo.deleteById(id);
            tokenRepo.deleteById(id);
            return "Success!";
        } 
        else {
            return "Wrong key!";
        }
    }

}
