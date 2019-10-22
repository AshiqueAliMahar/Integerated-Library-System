package BeanClasses;

public class Department {

        private String DeptNameString;
        
    public Department() {
    }

    public Department(String DeptNameString) {
        this.DeptNameString = DeptNameString;
        
    }

    public String getDeptNameString() {
        return DeptNameString;
    }

    public void setDeptNameString(String DeptNameString) {
        this.DeptNameString = DeptNameString;
    }
    public String toString(){
        return DeptNameString;
    }
}
