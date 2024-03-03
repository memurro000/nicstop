package com.murro.nicstop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.lang.NonNull;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class UserSignToken {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @Column(nullable = false)
    private Integer key;
    
}
