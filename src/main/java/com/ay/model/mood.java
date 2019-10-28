package com.ay.model;

import lombok.Data;

import java.util.Date;

@Data
public class mood {

    private String id;

    private String content;

    private String praiseNum;

    private String userId;

    private Date publishTime;

}
