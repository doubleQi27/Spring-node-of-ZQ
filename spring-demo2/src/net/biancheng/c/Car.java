package net.biancheng.c;

public class Car {
    private String brand;
    private double price;
    private int maxSpeed;

    //无参构造
    public Car(){

    }

    //采用setter方式注入，必须提供 getter 和 setter 方法（实际上是 set 方法必须有）
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    //重写 toString
    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
