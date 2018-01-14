package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){ return userRepository.findOne(id); }
    public User getUserByLogin(String login){ return userRepository.findByName(login); }

    public User getPostedUser(User user){ return user;}

    public User createUser(String name, String lastName, String email, String login, String password, boolean isRespoAPP, boolean isAdmin, boolean isTutor, boolean isStudent){
        UUID generatedUUID= UUID.randomUUID();
        String uuid = generatedUUID.toString();
        User user = new User(name, lastName, email, login, password, uuid, isRespoAPP, isAdmin, isTutor, isStudent);
        userRepository.save(user);
        return user;
    }
}
