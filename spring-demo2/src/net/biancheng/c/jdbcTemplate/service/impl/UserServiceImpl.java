package net.biancheng.c.jdbcTemplate.service.impl;

import net.biancheng.c.jdbcTemplate.dao.IUserDao;
import net.biancheng.c.jdbcTemplate.entity.UserEntity;
import net.biancheng.c.jdbcTemplate.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//服务层的 Bean
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public int addUser(UserEntity user) {
        return userDao.addUser(user);
    }
    @Override
    public int updateUser(UserEntity user) {
        return userDao.update(user);
    }
    @Override
    public int deleteUser(UserEntity user) {
        return userDao.delete(user);
    }
    @Override
    public int countUser(UserEntity user) {
        return userDao.count(user);
    }
    @Override
    public List<UserEntity> getUserList(UserEntity user) {
        return userDao.getList(user);
    }
    @Override
    public UserEntity getUser(UserEntity user) {
        return userDao.getUser(user);
    }
    @Override
    public void batchAddUser(List<Object[]> batchArgs) {
        userDao.batchAddUser(batchArgs);
    }
}
