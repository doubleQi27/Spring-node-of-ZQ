package net.biancheng.c;

public class Dept3 {
    private String deptName;
    private String deptID;

    public Dept3(){

    }

    //构造方式注入必须得有全构造函数（如果只注入部分，那么也可以是部分构造函数）
    public Dept3(String deptName, String deptID){
        this.deptName = deptName;
        this.deptID = deptID;
    }

    @Override
    public String toString(){
        return "Dept3{" +
                "deptName=" + deptName +
                ", deptID='" + deptID +
                '}';
    }
}
