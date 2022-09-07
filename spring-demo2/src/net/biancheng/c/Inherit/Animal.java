package net.biancheng.c.Inherit;

public class Animal {

    private String name;
    private Integer age;

    public void setName(String name) {
        System.out.println("Animal setName：" + name);
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("Animal setAge：" + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}