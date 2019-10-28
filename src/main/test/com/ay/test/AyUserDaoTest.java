package com.ay.test;

import com.ay.dao.AyUserDao;
import com.ay.model.AyUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AyUserDaoTest extends BaseJunit4Test {

    @Autowired
    private AyUserDao userDao;

    @Test
    public void testFindAll() {
        List<AyUser> userList = userDao.findAll();
        System.out.println(userList.size());
    }
}
