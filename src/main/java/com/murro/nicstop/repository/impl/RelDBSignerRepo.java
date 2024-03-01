package com.murro.nicstop.repository.impl;

import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.repository.SignerRepo;
import org.springframework.context.annotation.Primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface RelDBSignerRepo 
        extends SignerRepo, JpaRepository<UserSigner, Long>{

}
