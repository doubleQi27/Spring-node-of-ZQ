package net.biancheng.c.transaction.dao;

import net.biancheng.c.transaction.entity.AccountEntity;

import java.math.BigDecimal;

public interface IAccountDao {

    /**
     * 根据用户查询账户金额
     * @param userId
     * @return
     */
    AccountEntity selectByUserId(String userId);

    /**
     * 扣减账户金额
     * @param userId
     * @param money
     * @return
     */
    int decrease(String userId, BigDecimal money);

}
