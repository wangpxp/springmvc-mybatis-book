package com.ay.dao;

import com.ay.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User find(String id);
}
