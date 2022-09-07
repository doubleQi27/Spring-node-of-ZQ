package net.biancheng.c.jdbcTemplate.dao;

import net.biancheng.c.jdbcTemplate.entity.UserEntity;

import java.util.List;

public interface IUserDao {

    /**
     * 新增一条用户
     *
     * @param user
     * @return
     */
    int addUser(UserEntity user);
    /**
     * 更新指定的用户信息
     *
     * @param user
     * @return
     */
    int update(UserEntity user);
    /**
     * 删除指定的用户信息
     *
     * @param user
     * @return
     */
    int delete(UserEntity user);
    /**
     * 统计用户个数
     *
     * @param user
     * @return
     */
    int count(UserEntity user);
    /**
     * 查询用户列表
     *
     * @param user
     * @return
     */
    List<UserEntity> getList(UserEntity user);
    /**
     * 查询单个用户信息
     *
     * @param user
     * @return
     */
    UserEntity getUser(UserEntity user);
    /**
     * 批量增加用户
     *
     * @param batchArgs
     */
    void batchAddUser(List<Object[]> batchArgs);
}
