package net.biancheng.c.autowired;

public class Employee {
    //员工编号
    private String empNo;
    //员工姓名
    private String empName;
    //部门信息
    //byName 自动装配方式，则 XML 中的 Bean id或name 必须与此处类属性名称相同
    //byType 自动装配方式，则 XML 中的 Bean id或name 无需与此处类属性名称相同，但此类型的 Bean 只能有一个
    private Dept dept;

    public Employee() {
        System.out.println("正在执行 Employee 的无参构造方法>>>>");
    }

    public Employee(String empNo, String empName, Dept dept) {
        System.out.println("正在执行 Employee 的有参构造方法>>>>");
        this.empNo = empNo;
        this.empName = empName;
        this.dept = dept;
    }

    public void setEmpNo(String empNo) {
        System.out.println("正在执行 Employee 的 setEmpNo 方法>>>>");
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        System.out.println("正在执行 Employee 的 setEmpName 方法>>>>");
        this.empName = empName;
    }

    public void setDept(Dept dept) {
        System.out.println("正在执行 Employee 的 setDept 方法>>>>");
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }
}
