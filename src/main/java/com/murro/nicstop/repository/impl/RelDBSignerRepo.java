package com.murro.nicstop.repository.impl;

import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignerRepo;
import org.springframework.context.annotation.Primary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface RelDBSignerRepo 
        extends SignerRepo{

    @Override
    @Query(value = "SELECT * FROM user_signer "
            + "WHERE commentary IS NOT NULL "
            + "ORDER BY random() LIMIT 1", 
            nativeQuery = true)
    UserSigner findRandomUserSignerWithCommentary();

}
