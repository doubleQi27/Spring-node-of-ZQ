package net.biancheng.c.jdbcTemplate.dao.impl;

import net.biancheng.c.jdbcTemplate.dao.IUserDao;
import net.biancheng.c.jdbcTemplate.entity.UserEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

// 持久层的 Bean
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    //@Resource，基于注解的 Bean 自动装配。默认按照 byName 方式进行装配，但也可以按照 byType 的方式进行装配
    //@Autowired 是默认 byType 方式进行装配的
    //理解自动注入：
    //@Component、@Repository、@Service、@Controller 让 spring 容器将 java 类识别并注册为容器中的 Bean
    //@Autowired、@Resource表示自动装配（依赖注入）
    //被注入的和要被注入的，都得是容器中的 Bean，不管是用注解定义还是在 XML 中定义
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(UserEntity user) {
        String sql = "INSERT into `user` (`user`.user_name,`user`.`status`) VALUES(?,?);";
        int update = jdbcTemplate.update(sql, user.getUserName(), user.getStatus());
        return update;
    }
    @Override
    public int update(UserEntity user) {
        String sql = "UPDATE `user` SET status=? WHERE user_name=?;";
        return jdbcTemplate.update(sql, user.getStatus(), user.getUserName());
    }
    @Override
    public int delete(UserEntity user) {
        String sql = "DELETE FROM `user` where user_name=?;";
        return jdbcTemplate.update(sql, user.getUserName());
    }
    @Override
    public int count(UserEntity user) {
        String sql = "SELECT COUNT(*) FROM `user` where `status`=?;";
        return jdbcTemplate.queryForObject(sql, Integer.class, user.getStatus());
    }
    @Override
    public List<UserEntity> getList(UserEntity user) {
        String sql = "SELECT * FROM `user` where `status`=?;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), user.getStatus());
    }
    @Override
    public UserEntity getUser(UserEntity user) {
        String sql = "SELECT * FROM `user` where `user_id`=?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserEntity>(UserEntity.class), user.getUserId());
    }
    @Override
    public void batchAddUser(List<Object[]> batchArgs) {
        String sql = "INSERT into `user` (`user`.user_name,`user`.`status`) VALUES(?,?);";
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
