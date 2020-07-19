package org.techmeskills.aqa5.auf.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder(toBuilder = true)
@ToString(exclude = "name")
public class User {
    String name;
    String surname;
    String email;
    boolean isActive;
    int age;
    int id;
    String username;
    String password;
    String address;
}
