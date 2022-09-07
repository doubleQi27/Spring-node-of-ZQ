package net.biancheng.c.transaction.dao.impl;

import net.biancheng.c.transaction.dao.IAccountDao;
import net.biancheng.c.transaction.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public AccountEntity selectByUserId(String userId) {
        String sql = "  select * from account where user_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AccountEntity>(AccountEntity.class), userId);
    }
    @Override
    public int decrease(String userId, BigDecimal money) {
        String sql = "UPDATE account SET residue = residue - ?, used = used + ? WHERE user_id = ?;";
        return jdbcTemplate.update(sql, money, money, userId);
    }
}
