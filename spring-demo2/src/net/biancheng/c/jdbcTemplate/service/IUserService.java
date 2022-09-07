package net.biancheng.c.jdbcTemplate.service;

import net.biancheng.c.jdbcTemplate.entity.UserEntity;

import java.util.List;

public interface IUserService {

    /**
     * 新增用户数据
     *
     * @param user
     * @return
     */
    public int addUser(UserEntity user);
    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    public int updateUser(UserEntity user);
    /**
     * 删除用户数据
     *
     * @param user
     * @return
     */
    public int deleteUser(UserEntity user);
    /**
     * 统计用户数量
     *
     * @param user
     * @return
     */
    public int countUser(UserEntity user);
    /**
     * 查询用户数据
     *
     * @param user
     * @return
     */
    public List<UserEntity> getUserList(UserEntity user);
    /**
     * 查询单个用户信息
     *
     * @param user
     * @return
     */
    public UserEntity getUser(UserEntity user);
    /**
     * 批量添加用户
     *
     * @param batchArgs
     */
    public void batchAddUser(List<Object[]> batchArgs);
}
