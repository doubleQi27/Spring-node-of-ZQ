package net.biancheng.c.jdbcTemplate;

import net.biancheng.c.jdbcTemplate.entity.UserEntity;
import net.biancheng.c.jdbcTemplate.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
        IUserService userService = context.getBean("userService", IUserService.class);

        UserEntity user = new UserEntity();
        user.setUserName("小张");
        user.setStatus("离线");
        //新增一个用户
        int i = userService.addUser(user);
        System.out.println("新增用户成功！");
        UserEntity user1 = new UserEntity();
        //修改用户
        user1.setUserName("小张");
        user1.setStatus("在线");
        int u = userService.updateUser(user1);
        System.out.println("修改用户成功");
        //批量增加用户
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"小明", "在线"};
        Object[] o2 = {"小龙", "离线"};
        Object[] o3 = {"小林", "在线"};
        Object[] o4 = {"小李", "在线"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        batchArgs.add(o4);
        userService.batchAddUser(batchArgs);
        System.out.println("批量增加完毕");
        //统计某状态下用户的数量
        UserEntity user2 = new UserEntity();
        user2.setStatus("在线");
        int i1 = userService.countUser(user2);
        System.out.println("在线用户的个数为：" + i1);
        //查询用户数据
        List<UserEntity> userList = userService.getUserList(user2);
        System.out.println("在线用户列表查询成功！");
        //输出
        for (UserEntity user4 : userList) {
            System.out.println("用户 ID:" + user4.getUserId() + "，用户名：" + user4.getUserName() + "，状态：" + user4.getStatus());
        }
    }
}
