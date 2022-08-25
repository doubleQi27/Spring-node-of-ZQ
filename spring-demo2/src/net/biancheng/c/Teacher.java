package net.biancheng.c;

public class Teacher {
    private String name;
    private String kemu;
    private Car car;

    public Teacher(){

    }

    //用于 setter 注入的 getter 及 setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    //重写 toString
    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + name +
                ", kemu='" + kemu +
                ", car=" + car.toString() +
                '}';
    }
}
