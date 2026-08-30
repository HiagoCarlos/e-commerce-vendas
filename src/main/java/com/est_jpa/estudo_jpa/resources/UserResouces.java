package com.est_jpa.estudo_jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.est_jpa.estudo_jpa.Entity.User;


@RestController
@RequestMapping(value = "/users")
public class UserResouces {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User("Maria", "maria@gmail.com", "123456", "999999999");
        return ResponseEntity.ok().body(u);
    }
}
