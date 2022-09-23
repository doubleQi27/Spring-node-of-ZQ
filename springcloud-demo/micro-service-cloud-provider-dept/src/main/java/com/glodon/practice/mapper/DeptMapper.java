package com.glodon.practice.mapper;

import com.glodon.practice.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component       //注册到 IoC 容器
@Mapper       // 标记为 Mapper，接口映射
public interface DeptMapper {

    //根据主键获取数据
    Dept selectByPrimaryKey(Integer deptNo);

    //获取表中的全部数据
    List<Dept> GetAll();
}
