package com.service;


import com.dao.LoginRepository;
import com.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Loginservice {
    @Autowired
    LoginRepository loginRepository;
    public Login login(String username,String password){
        Login user = loginRepository.findByUsernameAndPassword(username, password);
        return user;

    }
}
