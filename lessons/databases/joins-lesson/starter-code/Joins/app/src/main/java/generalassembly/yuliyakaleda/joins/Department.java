package generalassembly.yuliyakaleda.joins;


public class Department {
  private String dept;
  private int empId;

  public Department(String dept, int empId) {
    this.dept = dept;
    this.empId = empId;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }
}
