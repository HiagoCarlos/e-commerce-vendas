package com.est_jpa.estudo_jpa.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.est_jpa.estudo_jpa.common.Exception.DatabaseException;
import com.est_jpa.estudo_jpa.common.Exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public User update(UUID id, User obj){
        try {
        User existingObj = userRepository.getReferenceById(id);
        updateData(existingObj, obj);
        return userRepository.save(existingObj);
        } catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
    }

   public User delete(UUID id) {
		try {
			User obj = userRepository.getReferenceById(id);
			userRepository.deleteById(id);
			return obj;
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

    private void updateData(User existingObj, User obj) {
        existingObj.setName(obj.getName());
        existingObj.setEmail(obj.getEmail());
        existingObj.setPhone(obj.getPhone());
    }
}
