package com.murro.nicstop.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Primary;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignerRepo;

@Repository
@Primary
public class InMemorySignerRepo implements SignerRepo {

    private final List<UserSigner> SIGNERS = new ArrayList<>();
    private final List<UserSignToken> TOKENS = new ArrayList<>();

    @Override
    public List<UserSigner> findAllSigners() {
        System.out.println(TOKENS);
        return SIGNERS;
    }
    
    @Override
    public UserSignToken saveSigner(UserSigner signer, int key) {
        UserSignToken token =
                    UserSignToken.builder()
                    .id(signer.getId()).key(key)
                    .build();

        return 
            SIGNERS.add(signer) == true &&
            TOKENS.add(token)   == true ?
            token : null;
    }

    @Override
    public UserSigner findById(int id) {
        System.out.println(
                TOKENS.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst().orElse(null)
            );

        return 
            SIGNERS.stream()
            .filter(element -> element.getId().equals(id))
            .findFirst().orElse(null);
    }

    @Override
    public String updateSigner(UserSigner signer, int key) {
        int signerId = IntStream.range(0, SIGNERS.size())
            .filter(i -> SIGNERS.get(i).getId().equals(signer.getId()) &&
                    TOKENS.get(i).getKey().equals(key))
            .findFirst().orElse(-1);
        if(signerId > -1){
            SIGNERS.set(signerId, signer);
            return "Success";
        }
        else {
            return "Failed";
        }
    }

    @Override
    public String deleteSigner(int id, int key) {
        if(TOKENS.get(id).getKey().equals(key)){
            var signer = findById(id);
            SIGNERS.remove(signer);
            return "Success";
        }
        else {
            return "Failed";
        }
    }
}
