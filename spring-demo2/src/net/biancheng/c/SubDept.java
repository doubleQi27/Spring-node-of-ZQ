package net.biancheng.c;

public class SubDept {
    private String subDeptName;
    private String subDeptID;

    public SubDept(){

    }

    public SubDept(String subDeptName, String subDeptID){
        this.subDeptName = subDeptName;
        this.subDeptID = subDeptID;
    }



    @Override
    public String toString(){
        return "SubDept{" +
                "subDeptName=" + subDeptName +
                ", subDeptID=" + subDeptID +
                '}';
    }
}
