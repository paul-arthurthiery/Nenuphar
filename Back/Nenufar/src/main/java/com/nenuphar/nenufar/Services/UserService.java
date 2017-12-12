package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){ return userRepository.findOne(id); }

    public User getPostedUser(User user){ return user;}
}
