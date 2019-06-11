package com.api.airlines.Service;

import com.api.airlines.Model.Request.UserDetail;
import com.api.airlines.Model.Response.UserRest;

public interface UserService {
    UserRest createUser(UserDetail userDetail);
}
