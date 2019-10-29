package com.ay.model;

import lombok.Data;

import java.util.Date;

@Data
public class Mood {

    private String id;

    private String content;

    private Integer praiseNum;

    private String userId;

    private Date publishTime;

}
