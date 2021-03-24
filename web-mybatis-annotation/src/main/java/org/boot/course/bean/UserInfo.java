package org.boot.course.bean;

import lombok.Data;

@Data
public class UserInfo {
    private String name;
    private String password;
    private Integer age;
    private String location;
    
    private String career;
}
