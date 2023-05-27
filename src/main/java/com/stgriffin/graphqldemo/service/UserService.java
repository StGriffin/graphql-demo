package com.stgriffin.graphqldemo.service;

import com.stgriffin.graphqldemo.model.User;
import com.stgriffin.graphqldemo.model.UserRequest;
import com.stgriffin.graphqldemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Kullanıcı bulunamadı")
        );
    }

    public User createUser(UserRequest userRequest) {
        User user = new User(userRequest.getUserName(), userRequest.getMail(), userRequest.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        User existingUser = getUserById(id);
        userRepository.delete(existingUser);

    }

    public User updateUser(UserRequest userRequest) {
        User existingUser = getUserById(String.valueOf(userRequest.getId()));
        existingUser.set_role(userRequest.getRole());
        existingUser.set_userName(userRequest.getUserName());
        existingUser.set_mail(userRequest.getMail());
        return userRepository.save(existingUser);
    }
}
