package net.biancheng.c.domainobject.service.impl;

import net.biancheng.c.domainobject.dao.UserDao;
import net.biancheng.c.domainobject.entity.User;
import net.biancheng.c.domainobject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 服务层的 bean
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
}
