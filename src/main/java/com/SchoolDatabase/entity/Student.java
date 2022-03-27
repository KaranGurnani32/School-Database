package com.SchoolDatabase.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;


//JPA - It is a collection of method and classes that have been provided by oracle
//to store massive amounts of data in a database. Java developers use lots of code
//to interact with databases. With JPA, the burden of interacting with database is
//reduced as it forms bridge b/w object models(Java program) & relational models (database program)
@Entity
//@Entity - It means a table will be created by name of class.
//@Table - in order to specify name of table we use @Table
@Data
//@Data - Helps in creating getters and setters.(lombok feature)
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Builder is used for using Builder pattern without writing boilerplate code
public class Student {

    @Id
    //We use @Id to make id a primary key which uniquely identifies a row.
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )

    private Long id;

    @Column(name = "first_name_1")
    private String firstName;

    private String lastName;
    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String emailId;
}
