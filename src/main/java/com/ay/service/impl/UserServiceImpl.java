package com.ay.service.impl;

import com.ay.dao.UserDao;
import com.ay.dto.UserDTO;
import com.ay.model.User;
import com.ay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDTO find(String id) {
        User user = userDao.find(id);
        return convertModel2DTO(user);
    }

    private UserDTO convertModel2DTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAccount(user.getAccount());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
