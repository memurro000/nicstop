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

//THE CLASS NOW USES A COLUMN DEFINITION TEXT FOR commentary FIELD
//BY THE REASON PostgreSQL WON'T WORK WITH LOB ANNOTATION
//IT CAN CAUSE ISSUES WITH INTEGRATING OTHER DBMS OR OTHER
@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class UserSigner {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private Integer experience;
    @NonNull
    @Column(nullable = false)
    private String kindOfNicotine;
    @NonNull
    @Column(nullable = false)
    private Boolean physicallyAffected;

    @Column(columnDefinition = "text")
    private String commentary;

}

