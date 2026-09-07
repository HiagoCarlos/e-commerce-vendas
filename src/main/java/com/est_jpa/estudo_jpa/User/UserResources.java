package com.est_jpa.estudo_jpa.User;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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

    @PostMapping(value = "/insert")
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable UUID id){
        User obj = userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User entity) {
        User updatedUser = userService.update(id, entity);
        return ResponseEntity.ok().body(updatedUser);
    }
}
