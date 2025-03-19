package com.college.shre.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.shre.entity.User;

@Service
public class UserServiceImpl {


    ArrayList<User> users=new ArrayList<>();

    public User createUser(User user) {

        System.out.println(user);
        users.add(user);
        return user;
        
    }

    public String updateUser()
    {
        return "updated user";
    }

    public String deleteUser()
    {
        return "deleted user";
    }

    public List<User> getUser()
    {
        return users;
    }

}
