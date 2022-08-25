package net.biancheng.c;

public class Employee2 {
    //员工编号
    private String empNo;
    //员工姓名
    private String empName;
    //部门信息
    private Dept2 dept2;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Dept2 getDept() {
        return dept2;
    }

    public void setDept(Dept2 dept2) {
        this.dept2 = dept2;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", dept2=" + dept2 +
                '}';
    }
}
