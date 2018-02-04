package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.User;
import com.nenuphar.nenufar.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){ return userRepository.findOne(id); }
    public User getUserByLogin(String login){ return userRepository.findByLogin(login); }

    public User getUserByUUID(String uuid)
    {
        User temp = userRepository.getByUuid(uuid);
        User user = new User();
        user.setId(temp.getId());
        user.setLogin(temp.getLogin());
        user.setAdmin(temp.isAdmin());
        user.setEmail(temp.getEmail());
        user.setLastName(temp.getLastName());
        user.setName(temp.getName());
        user.setPassword(temp.getPassword());
        user.setRespoAPP(temp.isRespoAPP());
        user.setStudent(temp.isStudent());
        return user;
    }
    public User getFromCompleteName(String name, String last_name){ return userRepository.getFromCompleteName(name,last_name);}

    public User getPostedUser(User user){ return user;}

    public User createUser(String name, String lastName, String email, String login, String password, boolean isRespoAPP, boolean isAdmin, boolean isTutor, boolean isStudent){
        UUID generatedUUID= UUID.randomUUID();
        String uuid = generatedUUID.toString();
        User user = new User(name, lastName, email, login, password, isRespoAPP, isAdmin, isTutor, isStudent);
        userRepository.save(user);
        return user;
    }


    public boolean checkUserUUID(String uuid)
    {
        User user = getUserByUUID(uuid);
        if(user == null){return false;}
        return true;
    }

     public List<User> getTeamMatesFromUUID(String uuid)
    {
        try
        {
            boolean check_uuid = checkUserUUID(uuid);
            if (!check_uuid){ return null; }
            List<User> members = userRepository.getTeamMatesFromUUID(uuid);
            return members;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public List<User> getWorkgroupMembersFromUUID(String uuid) {
        try
        {
            boolean check_uuid = checkUserUUID(uuid);
            if (!check_uuid)
            {
                return null;
            }
            List<User> members = userRepository.getWorkgroupMembersFromUUID(uuid);
            return members;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public void changePassword(User user, String password){
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public void generateUUID(User user, String uuid) {
        user.setUuid(uuid);
        userRepository.save(user);
    }
}
