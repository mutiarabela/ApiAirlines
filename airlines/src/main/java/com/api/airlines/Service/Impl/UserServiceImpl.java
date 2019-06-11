package com.api.airlines.Service.Impl;

import com.api.airlines.Service.UserService;
import com.api.airlines.Model.Request.UserDetail;
import com.api.airlines.Model.Response.UserRest;
import com.api.airlines.Shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetail userDetail){
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetail.getEmail());
        returnValue.setFirstName(userDetail.getFirstName());
        returnValue.setLastName(userDetail.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }
}
