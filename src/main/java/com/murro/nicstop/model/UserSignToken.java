package com.murro.nicstop.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserSignToken {

    @NonNull
    private Integer id;
    @NonNull
    private Integer key;
    
}
