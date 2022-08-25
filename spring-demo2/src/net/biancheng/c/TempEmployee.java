package net.biancheng.c;

public class TempEmployee {
    private String TMName;
    private String TMID;
    private SubDept TMDept;

    public TempEmployee(){

    }

    public TempEmployee(String TMName, String TMID, SubDept TMDept){
        this.TMName = TMName;
        this.TMID = TMID;
        this.TMDept = TMDept;
    }

    @Override
    public String toString(){
        return "TempEmployee{" +
                "TMName=" + TMName +
                ", TMID=" + TMID +
                "TMDept" + TMDept.toString() +
                '}';
    }
}
