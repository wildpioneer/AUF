package org.techmeskills.aqa5.auf.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class  UserSimple {
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
