package com.ay.dao;

import com.ay.model.UserMoodPraiseRel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMoodPraiseRelDao {

    boolean save(@Param("userMoodPraiseRel")UserMoodPraiseRel userMoodPraiseRel);
}
