package net.biancheng.c.autowired;

public class Dept {
    //部门编号
    private String deptNo;
    //部门名称
    private String deptName;

    public Dept() {
        System.out.println("正在执行 Dept 的无参构造方法>>>>");
    }

    public Dept(String deptNo, String deptName) {
        System.out.println("正在执行 Dept 的有参构造方法>>>>");
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public void setDeptNo(String deptNo) {
        System.out.println("正在执行 Dept 的 setDeptNo 方法>>>>");
        this.deptNo = deptNo;
    }

    public void setDeptName(String deptName) {
        System.out.println("正在执行 Dept 的 setDeptName 方法>>>>");
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }

}
