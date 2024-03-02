package com.murro.nicstop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.murro.nicstop.model.UserSignToken;
import com.murro.nicstop.model.UserSigner;
import com.murro.nicstop.service.SignerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/signers")
@AllArgsConstructor
public class SignerController {

    private final SignerService service;

    @GetMapping("/get/all")
    public List<UserSigner> findAll(){
        return service.findAllSigners();
    }

    @GetMapping("/get/@{id}")
    public UserSigner findById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("/get/random")
    public UserSigner getRandom(){
        return service.getRandom();
    }

    @PostMapping("/new")
    public UserSignToken saveSigner(@RequestBody UserSigner signer){
        return service.saveSigner(signer);
    }

    @PutMapping("/update")
    public String updateSigner(@RequestBody ObjectNode json){
        ObjectMapper mapper = new ObjectMapper();
        try{
        return service.updateSigner(
                mapper.treeToValue(
                    json.get("signer"), 
                    UserSigner.class
                    ), 
                json.get("key").asInt(0));
        }
        catch(JsonProcessingException ex){
            return "Wrong format!";
        }
    }

    @DeleteMapping(path = "/delete")
    public String deleteSigner(@RequestBody UserSignToken token){
        return service.deleteSigner(token);
    }
    
}






