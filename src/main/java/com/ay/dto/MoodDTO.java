package com.ay.dto;

import com.ay.model.Mood;
import lombok.Data;

@Data
public class MoodDTO extends Mood {
    private String userName;

    private String userAccount;
}
