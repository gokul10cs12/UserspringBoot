package com.example.springboot.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor

@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @NotEmpty(message = "name should not be empty")
    @NotNull
    private String name;
    @NotEmpty(message = "address should not be empty")
    private String address;
    @NotEmpty(message = "dob should not be empty")

    @NotNull
    private String email;

    private String dob;
    @NotNull(message = "age should not be empty")
    private int age;
}
