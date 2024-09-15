package com.ms.studentdashboard.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;
    private String universityName;
    private String course;

}
