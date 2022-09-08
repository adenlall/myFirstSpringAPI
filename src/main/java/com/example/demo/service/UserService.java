package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repos.UserRepo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userepo;
    public UserService(UserRepo userepo) {
        this.userepo = userepo;
    }

    public List<User> getUsers(){
        return userepo.findAll();
    }

    private boolean isEmailTaken(User user){
        if(userepo.findUserByEmail(user.getEmail()).isPresent()){
            return true;
        }
        return false;
    }
    public void saveUser(User user){
        if(!isEmailTaken(user)){
            userepo.save(user);
        }
    }
    public User getUserById(Long id){
        if(!userepo.existsById(id)) throw new IllegalStateException("no user with id : " + id + " exists!");
        return userepo.findById(id).get();
    }
    @Transactional
    public void putUser(Long id, String name, String username, String email, String about){
        User user = getUserById(id);
        if(name != null && name.length() > 3 && name.length() < 33 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }if(username != null && username.length() > 5 && username.length() < 99 && !Objects.equals(user.getUsername(), username)){
            user.setUsername(username);
        }if(email != null && email.length() > 3 && email.length() < 80 && !Objects.equals(user.getEmail(), email) && !isEmailTaken(user)){
            user.setEmail(email);
        }if(about != null && about.length() > 3 && about.length() < 100 && !Objects.equals(user.getAbout(), about)){
            user.setAbout(about);
        }

    }

}
