package com.ay.service.impl;

import com.ay.dao.UserMoodPraiseRelDao;
import com.ay.model.UserMoodPraiseRel;
import com.ay.service.UserMoodPraiseRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMoodPraiseRelServiceImpl implements UserMoodPraiseRelService {
    @Autowired
    private UserMoodPraiseRelDao userMoodPraiseRelDao;

    @Override
    public boolean save(UserMoodPraiseRel userMoodPraiseRel) {
        return userMoodPraiseRelDao.save(userMoodPraiseRel);
    }
}
