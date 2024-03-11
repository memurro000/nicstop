package com.murro.nicstop.repository;


import com.murro.nicstop.model.UserSigner;
import java.util.List;

public interface SignerRepo {

    UserSigner findRandomUserSignerWithCommentary();

    public List<UserSigner> findAll();

    public UserSigner getReferenceById(long id);

    public UserSigner save(UserSigner entity);

    public boolean existsById(Long id);

    public void deleteById(Long id);

}
