package com.murro.nicstop.repository.impl;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.repository.SignTokenRepo;
import org.springframework.context.annotation.Primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface RelDBSignTokenRepo 
        extends SignTokenRepo, JpaRepository<UserSignToken, Long>{

}
