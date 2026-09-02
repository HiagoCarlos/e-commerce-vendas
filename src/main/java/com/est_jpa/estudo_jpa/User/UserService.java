package com.est_jpa.estudo_jpa.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(UUID id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
