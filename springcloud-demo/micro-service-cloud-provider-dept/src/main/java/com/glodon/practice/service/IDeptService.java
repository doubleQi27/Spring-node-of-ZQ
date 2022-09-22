package com.glodon.practice.service;

import com.glodon.practice.entity.Dept;

import java.util.List;

public interface IDeptService {

    Dept get(Integer deptNo);

    List<Dept> selectAll();
}
