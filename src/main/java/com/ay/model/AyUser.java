package com.ay.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AyUser {

    private Integer id;
    private String name;
    private String password;
}
