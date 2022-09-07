package net.biancheng.c.transaction.dao;

import net.biancheng.c.transaction.entity.StorageEntity;

public interface IStorageDao {

    /**
     * 查询商品的库存
     * @param productId
     * @return
     */
    StorageEntity selectByProductId(String productId);

    /**
     * 扣减商品库存
     * @param record
     * @return
     */
    int decrease(StorageEntity record);
}
