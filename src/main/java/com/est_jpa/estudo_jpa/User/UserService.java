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

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public User update(UUID id, User obj){
        User existingObj = userRepository.getReferenceById(id);
        updateData(existingObj, obj);
        return userRepository.save(existingObj);
    }

    public User delete(UUID id){
        Optional<User> obj = userRepository.findById(id);
        userRepository.deleteById(id);
        return obj.get();
    }

    private void updateData(User existingObj, User obj) {
        existingObj.setName(obj.getName());
        existingObj.setEmail(obj.getEmail());
        existingObj.setPhone(obj.getPhone());
    }
}
