package net.biancheng.c.transaction.dao.impl;

import net.biancheng.c.transaction.dao.IStorageDao;
import net.biancheng.c.transaction.entity.StorageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("storageDao")
public class StorageDaoImpl implements IStorageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public StorageEntity selectByProductId(String productId) {
        String sql = "select *   from storage where product_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<StorageEntity>(StorageEntity.class), productId);
    }

    @Override
    public int decrease(StorageEntity record) {
        String sql = " update storage set  used =? ,residue=? where product_id=?";
        return jdbcTemplate.update(sql, record.getUsed(), record.getResidue(), record.getProductId());
    }
}
