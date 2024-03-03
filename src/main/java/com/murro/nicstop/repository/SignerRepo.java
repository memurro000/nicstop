package com.murro.nicstop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.murro.nicstop.model.UserSigner;

public interface SignerRepo extends JpaRepository<UserSigner, Long> {

    //The method declaration now depends on the used DBMS (itc PostgreSQL) 
    //due to it's complexity
    //ISSUES WITH INTEGRATING OTHER DBMS CAN BE CAUSED
    @Query(value = "SELECT * FROM user_signer "
            + "WHERE commentary IS NOT NULL "
            + "ORDER BY random() LIMIT 1", 
            nativeQuery = true)
    UserSigner findRandomUserSignerWithCommentary();

}
