package net.biancheng.c.di.usual;

public class Employee3 {
    private String emplName;
    private String emplID;
    private Dept3 dept3;

    public Employee3(){

    }

    public Employee3(String emplName, String emplID, Dept3 dept3){
        this.emplName = emplName;
        this.emplID = emplID;
        this.dept3 = dept3;
    }

    @Override
    public String toString(){
        return "Employee3{" +
                "emplName=" + emplName +
                ", emplID='" + emplID +
                ", dept3=" + dept3.toString() +
                '}';
    }
}
