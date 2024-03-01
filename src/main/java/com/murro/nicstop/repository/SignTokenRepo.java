package com.murro.nicstop.repository;

import com.murro.nicstop.model.UserSignToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignTokenRepo extends JpaRepository<UserSignToken, Long> {
    
}
