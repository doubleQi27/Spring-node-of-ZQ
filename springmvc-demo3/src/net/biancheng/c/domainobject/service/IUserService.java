package net.biancheng.c.domainobject.service;

import net.biancheng.c.domainobject.entity.User;

public interface IUserService {
    User getUserByUserName(String userName);
}
