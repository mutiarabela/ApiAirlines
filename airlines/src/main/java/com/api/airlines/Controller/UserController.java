package com.api.airlines.Controller;

import com.api.airlines.Model.Request.UpdUserDetail;
import com.api.airlines.Model.Request.UserDetail;
import com.api.airlines.Model.Response.UserRest;
import com.api.airlines.Service.Impl.UserServiceImpl;
import com.api.airlines.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping(path = "/{userId}",
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        String firstName = null;
        //
        //
        int firstNameLength = firstName.length();

        if(users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

//        UserRest returnValue = new UserRest();
//        returnValue.setEmail("bela@gmail.com");
//        returnValue.setFirstName("Mutiara");
//        returnValue.setLastName("Bela");
//
//        return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
//
//        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

//    @GetMapping
//    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
//                          @RequestParam(value = "limit", defaultValue = "5")int limit,
//                          @RequestParam(value = "sort", defaultValue = "desc", required = false )String sort){
//        return "Get user was called with user with page = " + page + " and limit = " + limit + " and sort = " + sort;
//    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE },
                 produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetail userDetail){

        UserRest returnValue = userService.createUser(userDetail);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE })
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdUserDetail userDetail){
        UserRest storedUserDetail = users.get(userId);
        storedUserDetail.setFirstName(userDetail.getFirstName());
        storedUserDetail.setLastName(userDetail.getLastName());

        users.put(userId, storedUserDetail);

        return storedUserDetail;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        users.remove(id);
        return ResponseEntity.noContent().build();
    }

}
