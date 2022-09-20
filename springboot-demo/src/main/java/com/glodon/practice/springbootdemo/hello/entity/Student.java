package com.glodon.practice.springbootdemo.hello.entity;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:student.properties")    // 自定义配置文件配置绑定
public class Student {

    private String name;
    private String age;
    private String schoolclass;
    private String grade;

    public Student(){}

    public Student(String name, String age, String schoolclass, String grade){
        this.name = name;
        this.age = age;
        this.schoolclass = schoolclass;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSchoolclass() {
        return schoolclass;
    }

    public void setSchoolclass(String schoolclass) {
        this.schoolclass = schoolclass;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", schoolclass='" + schoolclass + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
