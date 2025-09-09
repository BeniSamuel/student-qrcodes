package com.benisamuel.www.service;

import com.benisamuel.www.dto.UserDto;
import com.benisamuel.www.model.User;
import com.benisamuel.www.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }

    public User getUserById (Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail (String email) {
        return userRepository.getUserByEmail(email);
    }

    public User createUser (UserDto userDto) {
        User user = getUserByEmail(userDto.getEmail());
        if (user != null) {
            return null;
        }
        User newUser = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword(), userDto.getRole());
        return userRepository.save(newUser);
    }


}
