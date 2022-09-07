package net.biancheng.c.autowired.service.impl;

import net.biancheng.c.autowired.Employee;
import net.biancheng.c.autowired.dao.IUserDao;
import net.biancheng.c.autowired.dao.impl.UserDaoImpl;
import net.biancheng.c.autowired.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service：告诉 spring 容器这是业务层的 Bean
@Service("userService")
public class UserServiceImpl implements IUserService {

    //@Resource：按照 Bean 的名称进行自动装配（其它内容看笔记）
    @Resource
    private IUserDao iUserDao;

    //@Autowired：按照 Bean 的类型注入（其它内容看笔记）
//    @Autowired
//    public UserServiceImpl(IUserDao userDao){
//        this.userDao = userDao;
//    }

    public IUserDao getUserDao() {
        return iUserDao;
    }

    public void setUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void out() {
        iUserDao.print();
        System.out.println("一个精美而实用的网站");
    }
}
