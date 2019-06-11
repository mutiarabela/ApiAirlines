package com.api.airlines.Model.Request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdUserDetail {
    @NotNull(message = "First cannot be null")
    @Size(min=2, message = "First name must not be less than 2 characters")
    private String firstName;

    @NotNull(message = "Last cannot be null")
    @Size(min=2, message = "Last name must not be less than 2 characters")
    private String lastName;

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}
