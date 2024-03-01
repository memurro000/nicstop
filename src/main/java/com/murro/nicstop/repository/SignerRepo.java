package com.murro.nicstop.repository;

import com.murro.nicstop.model.UserSigner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignerRepo extends JpaRepository<UserSigner, Long> {
    
}
