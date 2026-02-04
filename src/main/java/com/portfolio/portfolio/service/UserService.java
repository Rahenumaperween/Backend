package com.portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.exception.ResourceNotFoundException;
import com.portfolio.portfolio.repository.UserRepository;

public class UserService {
	@Autowired
	private UserRepository userrepo;
	public List<User> getAllUsers(){
		return userrepo.findAll();
	}
	

	 // ✅ GET User By ID
    public User getUserById(Long id) {
        return userrepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );
    }
    // ✅ UPDATE User
    public User updateUser(Long id, User updatedUser) {

        User existingUser = getUserById(id);

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());

        return userrepo.save(existingUser);
    }
    // ✅ DELETE User
    public void deleteUser(Long id) {

        User user = getUserById(id);

        userrepo.delete(user);
    }
	
}
