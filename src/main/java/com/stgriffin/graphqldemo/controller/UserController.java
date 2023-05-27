package com.stgriffin.graphqldemo.controller;

import com.stgriffin.graphqldemo.model.User;
import com.stgriffin.graphqldemo.model.UserRequest;
import com.stgriffin.graphqldemo.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    List<User> getAllUsers(){
      return userService.getAllUsers();
    }

    @QueryMapping
    User getUserById(@Argument String id){
        return userService.getUserById(id);
    }

    @MutationMapping
    User createUser(@Argument UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @MutationMapping
    Boolean deleteUser(@Argument String id){
        userService.deleteUser(id);
        return true;
    }
    @MutationMapping
    User updateUser(@Argument UserRequest userRequest){
        return userService.updateUser(userRequest);
    }
}
