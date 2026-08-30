package com.est_jpa.estudo_jpa.resources;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.est_jpa.estudo_jpa.Entity.User;
import com.est_jpa.estudo_jpa.Service.UserService;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserResources {

    private final UserService userService;

    @GetMapping 
    public ResponseEntity<List<User>> findAll() {
       List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id){
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
