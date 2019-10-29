package com.ay.service;

import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoodService {
    List<MoodDTO> findAll();

    Mood findById(String id);

    boolean update(@Param("mood") Mood mood);

    boolean praiseMood(String useId, String moodId);

}
