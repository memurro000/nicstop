package com.murro.nicstop.repository.impl;

import org.springframework.data.jpa.repository.Query;

import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignerRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelDBSignerRepo 
        extends SignerRepo, JpaRepository<UserSigner, Long> {
    
    @Override
    @Query(value = "SELECT * FROM user_signer "
            + "WHERE commentary IS NOT NULL "
            + "ORDER BY random() LIMIT 1", 
            nativeQuery = true)
    public abstract UserSigner findRandomUserSignerWithCommentary();
    
}
