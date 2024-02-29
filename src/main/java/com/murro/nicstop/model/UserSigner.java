package com.murro.nicstop.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserSigner {

    @NonNull
    private Integer id;
    private Integer age;
    private Integer experience;
    private String kindOfNicotine;
    private Boolean physicalAffected;
    private Short ip;

}

