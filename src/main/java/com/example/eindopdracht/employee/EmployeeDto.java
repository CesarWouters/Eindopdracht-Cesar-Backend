package com.example.eindopdracht.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public EmployeeDto() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password= password;
    }


}
